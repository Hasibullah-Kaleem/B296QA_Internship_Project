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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class DB_US_01_02_17_18_Stepdefs {
    private ResultSet resultSet;
    @Given("the database connection is established")
    public void the_database_connection_is_established() {
        DBUtils.connectToDatabase();
    }
    @When("Admin Goychak executes the query {string}")
    public void admin_goychak_executes_the_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }
    @Then("Admin Goychak verifies the retrieved field names should contain the following columns:")
    public void admin_goychak_verifies_the_retrieved_field_names_should_contain_the_following_columns(DataTable dataTable){
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<String> expectedFields = dataTable.asList();
            for (int i = 1; i < metaData.getColumnCount(); i++) {
                String actualColumnName = metaData.getColumnName(i);
                assertTrue("Field name not found: "+ actualColumnName, expectedFields.contains(actualColumnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @When("Admin Goychak executes the query to fetch the record where id is {int} in {string} table")
    public void admin_goychak_executes_the_query_to_fetch_the_record_where_id_is_in_table(Integer id, String tableName) {
        resultSet = DBUtils.executeQuery("SELECT * FROM "+ tableName + " WHERE id = " + id + ";");
    }
    @Then("Admin Goychak verifies that the retrieved field data matches the expected values:")
    public void admin_goychak_verifies_that_the_retrieved_field_data_matches_the_expected_values(DataTable dataTable) {
        try {
            resultSet.next();
            for (Map<String, String> row : dataTable.asMaps()) {
                String column = row.get("Column Name");
                String expectedValue = row.get("Expected Value");
                String actualValue = resultSet.getObject(column).toString();
                Assert.assertEquals(expectedValue, actualValue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("Admin Goychak closes the database connection")
    public void admin_goychak_closes_the_database_connection() {
        DBUtils.closeConnection();
    }
}
