package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DB_US_11_Stepdefs {
    ResultSet resultSet;
    @When("Admin Hasibullah executes logs table query {string}")
    public void admin_hasibullah_executes_logs_table_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }
    @Then("Admin Hasibullah verifies that the log table should have the following columns:")
    public void admin_hasibullah_verifies_that_the_log_table_should_have_the_following_columns(DataTable dataTable) {
        List<String> expectedData = dataTable.asList();
        System.out.println(expectedData);
        List<String> actualData = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i<=metaData.getColumnCount(); i++){
                String actualColumn = metaData.getColumnName(i);
                actualData.add(metaData.getColumnName(i));
                assertTrue(actualData.contains(actualColumn));
                assertTrue(actualColumn, expectedData.contains(actualColumn));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @When("Admin Hasibullah executes the log query {string}")
    public void admin_hasibullah_executes_the_log_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }
    @Then("Admin Hasibullah verifies that the log table record should have the following values:")
    public void admin_hasibullah_verifies_that_the_log_table_record_should_have_the_following_values(DataTable dataTable) throws SQLException {
       Map<String,String> expectedData = dataTable.asMap();
        System.out.println(expectedData);
        Map<String,String> actualData = new LinkedHashMap<>();
       if (resultSet.next()){
           actualData.put("id",resultSet.getString("id"));
           actualData.put("created_at",resultSet.getString("created_at"));
           actualData.put("advert_id",resultSet.getString("advert_id"));
           actualData.put("user_id",resultSet.getString("user_id"));
           actualData.put("message",resultSet.getString("message"));
       }

        System.out.println(actualData);
       assertEquals(expectedData,actualData);
       assertTrue(actualData.containsValue("Tour request is created."));


    }
}