package getlandestate.stepdefs.api_stepdefs;

import getlandestate.utilities.Authentication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static getlandestate.utilities.Authentication.generateToken;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class API_US_04_Stepdefs {

    RequestSpecification spec;
    private Map<String, String > payload;
    Response response;
    String email = "admin@gmail.com";
    String password = "admin123!";



    @Given("the base URL {string} and path parameter {string} is used")
    public void the_base_url_and_path_parameter_is_used(String url, String path) {
        spec= new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath(path)
                .setContentType(ContentType.JSON)
                .build();
    }
    @Given("a payload is created with title {string}")
    public void a_payload_is_created_with_title(String title) {
        payload = new HashMap<>();
        payload.put("title", title);
    }
    @When("a post request is sent and a response is received")
    public void a_post_request_is_sent_and_a_response_is_received() {
        response = given(spec).when().body(payload).post();
    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode());
    }
    @Then("the response content type should be {string}")
    public void the_response_content_type_should_be(String expectedContentType) {
        assertEquals(expectedContentType, response.contentType());
    }
    @Then("the response name should be {string}")
    public void the_response_name_should_be(String expectedTitle) {
        assertEquals(expectedTitle, response.jsonPath().getString("title"));
    }
}
