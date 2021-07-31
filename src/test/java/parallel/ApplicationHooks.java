package parallel;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;
	@Before(order=0)
	public void getBrowserProperty(){
		configReader = new ConfigReader();
		prop = configReader.initProp();
	}
	@Before(order=1)
	public void launchBrowser(){
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initBrowser(browserName);
		Set<String> sessions = driver.getWindowHandles();
		for(String child:sessions) {
			driver.switchTo().window(child);
			if(driver.getTitle().equalsIgnoreCase("settings")) {
				driver.close();
			}
		}
	}
	@After(order=0)
	public void quitBrowser(){
		driver.quit();
	}
	@After(order=1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotName);
		}
	}

}
