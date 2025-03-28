package getlandestate.stepdefs.db_stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import getlandestate.utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;


public class DB_US_14_Stepdefs {

     ResultSet resultSet;

    @Given("Hulya connects to the database")
    public void hulya_connects_to_the_database() {
        DBUtils.connectToDatabase();
    }

    @When("Hulya runs the query {string}")
    public void hulya_runs_the_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }

    @Then("Hulya should see the following column headers in the result:")
    public void hulya_should_see_the_following_column_headers_in_the_result(DataTable dataTable) throws SQLException, SQLException {
        List<String> expectedColumns = dataTable.asList();

        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        int columnCount = rsMetaData.getColumnCount();

        for (String expectedColumn : expectedColumns) {
            boolean found = false;
            for (int i = 1; i <= columnCount; i++) {
                if (rsMetaData.getColumnName(i).equalsIgnoreCase(expectedColumn)) {
                    found = true;
                    break;
                }
            }
            Assert.assertTrue("Missing column: " + expectedColumn, found);
        }
    }

    @Then("Hulya verifies that the result contains at least one row")
    public void hulya_verifies_that_the_result_contains_at_least_one_row() throws SQLException {
        Assert.assertTrue("No rows found!", resultSet != null && resultSet.next());
    }

    @Then("Hulya closes the database connection")
    public void hulya_closes_the_database_connection() {
        DBUtils.closeConnection();
    }
}