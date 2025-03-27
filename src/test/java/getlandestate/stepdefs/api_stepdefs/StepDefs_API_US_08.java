package getlandestate.stepdefs.api_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static getlandestate.baseurl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefs_API_US_08 {

    private Response response; // Store response for later assertions

    @And("the users sets the url for Get user's log by id for API_US_{int}")
    public void theUsersSetsTheUrlForGetUserSLogByIdForAPI_US_(int id) {

        if (spec == null) {
            throw new IllegalStateException("❌ BaseUrl.spec is NULL. Ensure BaseUrl.setUp(email, password) is called before API requests.");
        }

        // Setting path parameters and query parameters
        spec.pathParam("first", "logs")
                .pathParam("second", id)
                .queryParam("page", "0")
                .queryParam("size", "20")
                .queryParam("sort", "message")
                .queryParam("type", "asc");
    }

    @And("the user sets the expected data for the logs")
    public void theUserSetsTheExpectedDataForTheLogs() {
        // Add expected data setup if needed

    }

    @When("the user sends a GET request to the logs api and gets the response")
    public void theUserSendsAGETRequestToApiLogAndGetsTheResponse(){
        response = given(spec)
                .when()
                .get("{first}/{second}"); // Corrected path parameters

        response.prettyPrint(); // Log response for debugging
    }

    @Then("the response status code is {int} for API_US_{int}")
    public void theResponseStatusCodeIsForAPI_US_(int expectedStatusCode, int apiId) {
        assertEquals("❌ Unexpected status code for API_US_" + apiId, expectedStatusCode, response.getStatusCode());
    }

    @And("the user verifies the response data for the logs for API_US_{int}")
    public void theUserVerifiesTheResponseDataForTheLogsForAPI_US_(int apiId) {
        assertEquals("application/json", response.getContentType());
        // Add further JSON data validation if required
    }



}












