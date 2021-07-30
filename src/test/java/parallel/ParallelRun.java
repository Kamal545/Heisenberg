package parallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/parallel/AccountsPage.feature"},
		glue = {"parallel"},
		monochrome = false,
		publish = true,
		dryRun = false,
		//tags = "@Smoke",
		plugin = {"pretty", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
	
				}
		)

public class ParallelRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	

}
