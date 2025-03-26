package getlandestate.stepdefs.api_stepdefs;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static getlandestate.utilities.Authentication.generateToken;
import static io.restassured.RestAssured.given;

public class API_US_02_Stepdefs {

    private RequestSpecification spec;
    Response response;

    @Given("user Goychak is authorised as ADMIN")
    public void user_goychak_is_authorised_as_admin() {
        String baseUri = "http://64.227.123.49:8092";
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + generateToken("admin@gmail.com", "admin123!"))
                .build();
    }
    @Given("admin Goychak sets the url for POST request")
    public void admin_goychak_sets_the_url_for_post_request() {
        ///categoriesKey/3/properties
        spec.pathParams("first", "categoriesKey", "second", 5, "third", "properties");

    }
    @Given("admin Goychak sets the expected data for the User")
    public void admin_goychak_sets_the_expected_data_for_the_user() {

    }
    @When("admin Goychak sends the request and gets the response")
    public void admin_goychak_sends_the_request_and_gets_the_response() {
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

    }
    @Then("admin Goychak verifies the status code is {int}")
    public void admin_goychak_verifies_the_status_code_is(Integer int1) {

    }
    @Then("verifies Goychak the response body")
    public void verifies_goychak_the_response_body() {

    }



















}
