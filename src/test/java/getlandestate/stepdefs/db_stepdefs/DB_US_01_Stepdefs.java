package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DB_US_01_Stepdefs {

    private ResultSet resultSet;
    private ResultSet resultSet2;

    //us_01_tc_01
    @When("Admin Goychak executes the query to retrieve the table names")
    public void admin_goychak_executes_the_query_to_retrieve_the_table_names() {
        resultSet = DBUtils.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';");
    }

    @Then("Admin Goychak verifies that the database should contain the following columns:")
    public void admin_goychak_verifies_that_the_database_should_contain_the_following_columns(DataTable dataTable) throws SQLException {
        List<String> expectedTableNames = dataTable.asList();
        while (resultSet.next()){
            String actualData = resultSet.getString("table_name");
            assertTrue("Column not found" + actualData, expectedTableNames.contains(actualData));
        }
    }

    //us_01_tc_02
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


























}
