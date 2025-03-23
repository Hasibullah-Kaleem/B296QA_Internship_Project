package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DB_US_13_StepDefs {

    ResultSet resultSet;

    @Given("Establish database connection")
    public void establish_database_connection() {
        DBUtils.connectToDatabase();
    }

    @When("Run the query {string}")
    public void run_the_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }

    @Then("Check if the table has the following columns:")
    public void check_if_the_table_has_the_following_columns(List<String> expectedColumns) throws SQLException {
        List<String> actualColumns = new java.util.ArrayList<>();
        while (resultSet.next()) {
            actualColumns.add(resultSet.getString("column_name"));
        }

        for (String expected : expectedColumns) {
            Assert.assertTrue("Missing column: " + expected, actualColumns.contains(expected));
        }



    }

    @Then("Confirm that the query result is greater than {int}")
    public void confirm_that_the_query_result_is_greater_than(Integer value) throws SQLException {
        resultSet.next();
        int count = resultSet.getInt(1);
        Assert.assertTrue("Expected count > " + value + " " + count, count > value);
    }

    @Then("Terminate the database connection")
    public void terminate_the_database_connection() {
        DBUtils.closeConnection();
    }





















}
