package getlandestate.stepdefs.db_stepdefs;


import io.cucumber.java.en.*;
import getlandestate.utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefs_DB_US_08 {
    ResultSet resultSet;

    @Given("Admin connects to the PostgreSql database for US_08")
    public void adminConnectsToThePostgreSqlDatabase() {
        DBUtils.connectToDatabase();
    }

    @When("Admin executes the query select * from districts for US_08")
    public void adminExecutesTheQuerySelectFromDistrictsForUS_08() {
        String query = "SELECT * FROM districts";
        resultSet = DBUtils.executeQuery(query);

    }

    @Then("Admin validates the columns name of the districts table")
    public void adminValidatesTheColumnsNameOfTheDistrictsTable() throws SQLException {

        assertEquals("id", resultSet.getMetaData().getColumnName(1));
        assertEquals("lat", resultSet.getMetaData().getColumnName(2));
        assertEquals("lng", resultSet.getMetaData().getColumnName(3));
        assertEquals("name", resultSet.getMetaData().getColumnName(4));
        assertEquals("city_id", resultSet.getMetaData().getColumnName(5));
    }

    //TC_02
    @When("Admin executes the query select * from districts where id = {int}")
    public void adminExecutesTheQuerySelectFromDistrictsWhereId(int arg0) {
        String query = "SELECT * FROM districts WHERE id = 48323";
        resultSet = DBUtils.executeQuery(query);
    }

    @Then("Admin validates the column information of the districts table for the given id")
    public void adminValidatesTheColumnInformationOfTheDistrictsTableForTheGivenId() throws SQLException {
        String query = "SELECT * FROM districts WHERE id = 48323";
        ResultSet resultSet = DBUtils.executeQuery(query);

        assertTrue(resultSet.next());
        assertEquals(48323, resultSet.getInt("id"));
        assertEquals(37.42426, resultSet.getDouble("lat"), 0.0);
        assertEquals(34.8727713, resultSet.getDouble("lng"), 0.0);
        assertEquals("Pozantı", resultSet.getString("name"));
        assertEquals(4121, resultSet.getInt("city_id"));

    }


}



