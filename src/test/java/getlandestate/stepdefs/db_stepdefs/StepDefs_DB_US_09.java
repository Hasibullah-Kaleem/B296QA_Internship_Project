package getlandestate.stepdefs.db_stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import getlandestate.utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefs_DB_US_09 {

    ResultSet resultSet;

        @Given("Admin connects to the PostgreSql database for US_09")
        public void adminConnectsToThePostgreSqlDatabase() {
            DBUtils.connectToDatabase();
        }

    @When("Admin executes the query select * from category_property_keys for US_{int}")
    public void adminExecutesTheQuerySelectFromCategory_property_keysForUS(int arg0) {
        String query = "SELECT * FROM category_property_keys";
        DBUtils.executeQuery(query);
    }

        @Then("Admin validates the columns name of the category_property_keys table")
        public void adminValidatesTheColumnsNameOfTheCategory_property_keysTable() throws SQLException {

            ResultSet resultSet = DBUtils.executeQuery("SELECT * FROM category_property_keys");
            assertEquals("id", resultSet.getMetaData().getColumnName(1));
            assertEquals("built_in", resultSet.getMetaData().getColumnName(2));
            assertEquals("key_type", resultSet.getMetaData().getColumnName(3));
            assertEquals("name", resultSet.getMetaData().getColumnName(4));
            assertEquals("prefix", resultSet.getMetaData().getColumnName(5));
            assertEquals("suffix", resultSet.getMetaData().getColumnName(6));
            assertEquals("category_id", resultSet.getMetaData().getColumnName(7));



            // Add more assertions as needed
        }
    @When("Admin executes the query select * from category_property_keys where id = {int}")
    public void adminExecutesTheQuerySelectFromCategory_property_keysWhereId(int arg0) {
        String query = "SELECT * FROM category_property_keys WHERE id = 5";
        resultSet=DBUtils.executeQuery(query);
    }
        @Then("Admin validates the column information of the category_property_keys table for id = {int}")
        public void adminValidatesTheColumnInformationOfTheCategory_property_keysTableForId(int id) throws SQLException {
            String query = "SELECT * FROM category_property_keys WHERE id = 5";
            ResultSet resultSet = DBUtils.executeQuery(query);
            assertTrue(resultSet.next());

            assertEquals(5, resultSet.getInt("id"));

            assertEquals(true, resultSet.getBoolean("built_in"));
            assertEquals("NUMBER", resultSet.getString("key_type"));
            assertEquals("Year of Build", resultSet.getString("name"));
            assertEquals(null, resultSet.getString("prefix"));
            assertEquals(null, resultSet.getString("suffix"));
            assertEquals(1, resultSet.getInt("category_id"));

        }



}

