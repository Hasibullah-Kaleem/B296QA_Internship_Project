package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DB_US_06_Stepdefs {

    private ResultSet resultSet;
    private  List<List<Object>> expectedColumnDataList;


    @Given("admin connects to the database for US_{int}")
    public void admin_connects_to_the_database_for_us(Integer int1) {

        DBUtils.connectToDatabase();

    }

    @When("admin executes the following SQL query to retrieve the data from cities table: {string}")
    public void admin_executes_the_following_sql_query_to_retrieve_the_data_from_cities_table(String query) {

        resultSet = DBUtils.executeQuery(query);


    }

    @Then("admin verifies the column names returned by the query match the  expected column names:")
    public void admin_verifies_the_column_names_returned_by_the_query_match_the_expected_column_names(List<String> expectedColumnNames) {

        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            List<String> actualColumnNames = new ArrayList<>();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                actualColumnNames.add(metaData.getColumnName(i));
            }
            assertEquals(expectedColumnNames, actualColumnNames);
            System.out.println("Column names match the expected values.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to verify column names.");
        }


    }



    //TC_02


    @When("admin executes the SQL query: {string}")
    public void admin_executes_the_sql_query(String query2) {

        resultSet = DBUtils.executeQuery(query2);



    }

    @Then("admin verifies the retrieved data returned by the query matches the  expected values")
    public void admin_verifies_the_retrieved_data_returned_by_the_query_matches_the_expected_values(DataTable dataTable) {

        try {
            Assert.assertTrue("No record found in the result set!", resultSet.next());

            for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
                String column = row.get("Column Name");
                String expectedValue = row.get("Expected Value");

                Object actualValueObject = resultSet.getObject(column);

                if ("lat".equalsIgnoreCase(column) || "lng".equalsIgnoreCase(column)) {

                    double expectedDouble = Double.parseDouble(expectedValue);
                    double actualDouble = resultSet.getDouble(column);

                    Assert.assertEquals("Mismatch in column '" + column + "'",
                            expectedDouble, actualDouble, 0.000001);
                } else {

                    String actualValue = (actualValueObject != null) ? actualValueObject.toString() : "null";
                    Assert.assertEquals("Mismatch in column '" + column + "'", expectedValue, actualValue);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while validating record data", e);
        }



    }
    @Then("admin closes the DB connection")
    public void admin_closes_the_db_connection() {

        DBUtils.closeConnection();

    }
}
