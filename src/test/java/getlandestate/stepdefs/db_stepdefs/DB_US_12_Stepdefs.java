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

public class DB_US_12_Stepdefs {

    ResultSet resultSet;
    @When("Admin Hasibullah executes images table query {string}")
    public void admin_hasibullah_executes_images_table_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }
    @Then("Admin Hasibullah verifies that the images table should have the following columns:")
    public void admin_hasibullah_verifies_that_the_images_table_should_have_the_following_columns(DataTable dataTable) throws SQLException {
        List<String> expectedData = dataTable.asList();
        System.out.println(expectedData);
        List<String> actualData = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i<= metaData.getColumnCount(); i++){
            actualData.add(metaData.getColumnName(i));
        }

        assertEquals(expectedData,actualData);
    }


    @When("Admin Hasibullah executes the images query {string}")
    public void admin_hasibullah_executes_the_images_query(String query) {
        resultSet = DBUtils.executeQuery(query);
    }
    @Then("Admin Hasibullah verifies that the images record should have the following values:")
    public void admin_hasibullah_verifies_that_the_images_record_should_have_the_following_values(DataTable dataTable) throws SQLException {
        Map<String,String> expectedData = dataTable.asMap();
        Map<String,Object> actualData = new LinkedHashMap<>();
        if (resultSet.next()){
            actualData.put("id",resultSet.getString("id"));
            actualData.put("data",resultSet.getString("data"));
            actualData.put("featured",resultSet.getObject("featured").toString());
            actualData.put("name",resultSet.getString("name"));


        }

        System.out.println(actualData);
        assertEquals(expectedData,actualData);
        assertTrue(actualData.containsValue("Comfortable house in Kusadasi"));

    }
}