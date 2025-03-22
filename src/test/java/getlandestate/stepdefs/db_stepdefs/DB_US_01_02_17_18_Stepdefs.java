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
    private ResultSet resultSet1;
    private ResultSet resultSet2;
    private ResultSet resultSet3;
    private ResultSet resultSet4;
    @Given("the database connection is established")
    public void the_database_connection_is_established() {
        DBUtils.connectToDatabase();
    }
    @When("Admin Goychak executes the query to retrieve the table names")
    public void admin_goychak_executes_the_query_to_retrieve_the_table_names() {
        resultSet1 = DBUtils.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';");
    }
    @Then("Admin Goychak verifies that the database should contain the following columns:")
    public void admin_goychak_verifies_that_the_database_should_contain_the_following_columns(DataTable dataTable) throws SQLException {
        List<String> expectedTableNames = dataTable.asList();
        while (resultSet1.next()){
           String actualData = resultSet1.getString("table_name");
           assertTrue("Column not found" + actualData, expectedTableNames.contains(actualData));
        }
    }
    @When("Admin Goychak executes the query to retrieve the number of tables in the database")
    public void admin_goychak_executes_the_query_to_retrieve_the_number_of_tables_in_the_database() {
        resultSet2 = DBUtils.executeQuery("SELECT COUNT (*) as table_count FROM information_schema.tables WHERE table_schema = 'public';");
    }
    @Then("Admin Goychak verifies that the retrieved number matches {string}")
    public void admin_goychak_verifies_that_the_retrieved_number_matches(String expectedCountOfTables) throws SQLException {
        while (resultSet2.next()){
            Integer actualCountOfTable = resultSet2.getInt("table_count");
            assertEquals(expectedCountOfTables, actualCountOfTable.toString());
        }
    }
    //us_02_tc_01
    @When("Admin Goychak executes the query to fetch field names from the categories table")
    public void admin_goychak_executes_the_query_to_fetch_field_names_from_the_categories_table() {
        resultSet3 = DBUtils.executeQuery("SELECT * FROM categories;");
    }
    @Then("Admin Goychak verifies the retrieved field names should contain the following columns:")
    public void admin_goychak_verifies_the_retrieved_field_names_should_contain_the_following_columns(DataTable dataTable) throws SQLException {
        List<String> expectedFields = dataTable.asList();
        ResultSetMetaData metaData = resultSet3.getMetaData();
        for (int i = 1; i < expectedFields.size(); i++) {
            String actualColumnName = metaData.getColumnName(i);
            assertTrue("Field name not found: "+ actualColumnName, expectedFields.contains(actualColumnName));
        }
    }
    //us_02_tc_02
    @When("Admin Goychak executes the query to fetch the record where id is {int}")
    public void admin_goychak_executes_the_query_to_fetch_the_record_where_id(Integer id) {
        resultSet4 = DBUtils.executeQuery("SELECT * FROM categories WHERE id = " + id + ";");
    }
    @Then("Admin Goychak verifies that the retrieved field data matches the expected values:")
    public void admin_goychak_verifies_that_the_retrieved_field_data_matches_the_expected_values(DataTable dataTable) throws SQLException {
        resultSet4.next();
        for (Map<String, String> w : dataTable.asMaps()) {
            String column = w.get("Column Name");
            String expectedValue = w.get("Expected Value");
            String actualValue = resultSet4.getObject(column).toString();
            Assert.assertEquals(expectedValue, actualValue);
        }
    }
    @Then("Admin Goychak closes the database connection")
    public void admin_goychak_closes_the_database_connection() {
        DBUtils.closeConnection();
    }
}
