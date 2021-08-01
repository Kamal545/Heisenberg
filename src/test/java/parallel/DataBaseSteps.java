package parallel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;

import com.pages.DataBase;
import com.qa.util.DBManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataBaseSteps {
	private ResultSet rs;
	DBManager db = new DBManager();
	DataBase dbdata = new DataBase();
	
	@Given("user connects to the Database")
	public void user_connects_to_the_database() {
	 System.out.println("User connected to Database");
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
	@Given("user connects to the Employee Database")
	public void user_connects_to_the_employee_database() throws ClassNotFoundException, SQLException {
		System.out.println("User connected to Employee Database");
			
	}
	@When("user validates the Employee data")
	public void user_validates_the_employee_data() {
	    
	}

	@Then("it should be")
	public void it_should_be(DataTable empTable) throws ClassNotFoundException, SQLException {
	   List<List<String>> expEmpData = empTable.asLists();
	   List<List<String>> actEmpData = dbdata.fetchEmpData();
	   System.out.println(expEmpData);
	   Assert.assertTrue(expEmpData.containsAll(actEmpData));
	}

}
