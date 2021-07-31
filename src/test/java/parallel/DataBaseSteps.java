package parallel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;

import com.qa.util.DBManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataBaseSteps {
	private ResultSet rs;
	DBManager db = new DBManager();
	
	@Given("user connects to the Database")
	public void user_connects_to_the_database() {
	
	}
	@When("user executes query {string}")
	public void user_executes_query(String query) {
		   try {
				rs=db.connectDB(query);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
	}

	@Then("employeeid should be {int} and max salary is {double}")
	public void employeeid_should_be_and_max_salary_is(Integer expid, Double expsalary) throws SQLException {
		int empid = 0;
		double salary=0;
		
		while(rs.next()) {
			 empid = rs.getInt("employee_id");
			 salary = rs.getDouble("salary");
		}
		Assert.assertTrue(expid==empid);
		Assert.assertTrue(expsalary==salary);
	}

}
