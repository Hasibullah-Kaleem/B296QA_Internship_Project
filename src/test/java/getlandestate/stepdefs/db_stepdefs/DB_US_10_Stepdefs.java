package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DB_US_10_Stepdefs {

    ResultSet resultSet;
    @Given("Admin Hasibullah connects to the database")
    public void admin_hasibullah_connects_to_the_database() {
        DBUtils.connectToDatabase();
    }
    @When("Admin Hasibullah  executes the query {string}")
    public void admin_hasibullah_executes_the_query(String query) {
         resultSet=DBUtils.executeQuery(query);
    }
    @Then("Admin Hasibullah verifies that the table should have the following columns:")
    public void u_admin_hasibullah_verifies_that_the_table_should_have_the_following_columns(DataTable table) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        List<String> expectedData = table.asList();
        List<String> actualData = new ArrayList<>();

        for (int i = 1 ; i<=metaData.getColumnCount();i++){
            System.out.println(metaData.getColumnName(i));
            actualData.add(metaData.getColumnName(i));
        }
        assertEquals("Columns not found",actualData,expectedData);
        assertTrue(actualData.contains("id"));
    }
    @Then("Admin Hasibullah closes the database connection")
    public void admin_hasibullah_closes_the_database_connection() {
        DBUtils.closeConnection();
    }

}