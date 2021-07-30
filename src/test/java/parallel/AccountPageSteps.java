package parallel;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;
    ConfigReader configReader = new ConfigReader();
    private Properties prop;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	    List<Map<String,String>> credsList = credTable.asMaps();	   
	    String username = credsList.get(0).get("username");
	    String pwd = credsList.get(0).get("password");
	    prop = configReader.initProp();
	    String url = prop.getProperty("url");	       
	    System.out.println(credsList);
	    DriverFactory.getDriver().get(url);
	    accountsPage = loginPage.doLogin(username, pwd);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable accSectionTable) {
	    List<String> expectedaccSections = accSectionTable.asList();
	    System.out.println(expectedaccSections);
	    List<String> actualaccSections = accountsPage.getAccountSections();
	    System.out.println(actualaccSections);
	    Assert.assertTrue(expectedaccSections.containsAll(actualaccSections));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer int1) {
	   Assert.assertTrue(accountsPage.getAccSectionsCount()==int1);
	}
	@Then("all sections links should be clickable and active")
	public void all_sections_links_should_be_clickable_and_active(DataTable sectionsTitles) {
		List<String> expectedsecsTitles = sectionsTitles.asList();
		System.out.println(expectedsecsTitles);
		List<String> actualsecsTitles = accountsPage.clickAccountSections();
		System.out.println(actualsecsTitles);
		Assert.assertTrue(expectedsecsTitles.containsAll(actualsecsTitles));	  
	}
	@Then("user gets Store Information")
	public void user_gets_store_information(DataTable storeinfoTable) {
		List<String> expectedstoreInfo = storeinfoTable.asList();	 
		System.out.println(expectedstoreInfo);
		List<String> actualStoreInfo = accountsPage.getStoreInfo();
		System.out.println(actualStoreInfo);
		Assert.assertTrue(expectedstoreInfo.containsAll(actualStoreInfo));
	
	}
	@Then("header should be {string}")
	public void header_should_be(String header) {
	    Assert.assertTrue(accountsPage.getStoreInfoHeader().contains(header));
	}

}
