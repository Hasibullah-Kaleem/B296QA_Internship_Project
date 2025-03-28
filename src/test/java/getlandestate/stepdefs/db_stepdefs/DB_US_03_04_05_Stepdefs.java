package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DB_US_03_04_05_Stepdefs {
    //common step definitions for DB_US_03, DB_US_04, DB_US_05 feature files

    private ResultSet resultSet;

    @Given("Admin Natalia connects to the database")
    public void adminNataliaConnectsToTheDatabase() {
        DBUtils.connectToDatabase();
    }

    @When("Admin Natalia executes the query {string}")
    public void adminNataliaExecutesTheQuery(String query) {
        resultSet = DBUtils.executeQuery(query);
    }

    @Then("Admin Natalia verifies that the table should have the following columns:")
    public void adminNataliaVerifiesThatTheTableShouldHaveTheFollowingColumns(DataTable dataTable) {
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<String> expectedColumns = dataTable.asList();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String actualColumn = metaData.getColumnName(i);
                Assert.assertTrue("Column not found: " + actualColumn, expectedColumns.contains(actualColumn));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while verifying columns", e);
        }
    }

    @Then("Admin Natalia verifies that the record should have the following values:")
    public void adminNataliaVerifiesThatTheRecordShouldHaveTheFollowingValues(DataTable dataTable) {
        try {
            Assert.assertTrue("No record found!", resultSet.next());
            for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
                String column = row.get("Column Name");
                String expectedValue = row.get("Expected Value");
                String actualValue = resultSet.getObject(column).toString();
                Assert.assertEquals("Mismatch in column: " + column, expectedValue, actualValue);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while validating record data", e);
        }
    }

    @And("Admin Natalia closes the database connection")
    public void adminNataliaClosesTheDatabaseConnection() {
        DBUtils.closeConnection();
    }
}