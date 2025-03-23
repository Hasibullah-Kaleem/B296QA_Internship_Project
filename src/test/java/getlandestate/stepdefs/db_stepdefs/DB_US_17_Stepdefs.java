package getlandestate.stepdefs.db_stepdefs;

import getlandestate.utilities.DBUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_US_17_Stepdefs {

    private ResultSet resultSet;

    @When("Admin Goychak executes the query {string} to retrieve invalid emails")
    public void admin_goychak_executes_the_query_to_retrieve_invalid_emails(String query) {
        resultSet = DBUtils.executeQuery(query);
    }

    @Then("Admin Goychak verifies that there are no invalid emails")
    public void admin_goychak_verifies_that_there_are_no_invalid_emails() {
        try {
            if (resultSet.next()) { // If there is at least one invalid email
                String invalidEmail = resultSet.getString("email");
                Assert.fail("Invalid email found in database: " + invalidEmail);
            } else {
                System.out.println("All emails are valid.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
