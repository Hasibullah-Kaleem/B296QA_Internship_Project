package getlandestate.stepdefs.api_stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static getlandestate.hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_US_01_Stepdefs {

    private Response response;

    @Given("admin Goychak sets the url for GET request for US01")
    public void admin_goychak_sets_the_url_for_get_request_for_us01() {
        spec.pathParams("first", "tour-requests", "second", "admin", "third", "count");
    }
    @Given("admin Goychak sets the expected data for the Get request for US01")
    public void admin_goychak_sets_the_expected_data_for_the_get_request_for_us() {

    }
    @When("admin Goychak sends the request and gets the Get response for US01")
    public void admin_goychak_sends_the_request_and_gets_the_get_response_for_us() {
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("admin Goychak verifies the status code of Get request is {int} for US01")
    public void admin_goychak_verifies_the_status_code_of_get_request_is_for_us(int statusCode) {
        assertEquals("Status code does not match the expected value.", statusCode, response.getStatusCode());
    }
    @Then("admin Goychak verifies the response body of Get request for US01")
    public void admin_goychak_verifies_the_response_body_of_get_request_for_us() {

    }
}
