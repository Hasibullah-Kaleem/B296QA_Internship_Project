package getlandestate.stepdefs.api_stepdefs;

import getlandestate.pojos.CategoryPropertyKeyPojo;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static getlandestate.utilities.Authentication.generateToken;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class API_US_02_Stepdefs {
    private RequestSpecification spec;
    private CategoryPropertyKeyPojo payload;
    private CategoryPropertyKeyPojo actualData;
    private Response response;
    private Integer id;
    JsonPath jsonPath;
    Map<String, Object> lastElement;
    @Given("user Goychak is authorised as ADMIN")
    public void user_goychak_is_authorised_as_admin() {
        String baseUri = "http://64.227.123.49:8092";
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + generateToken("admin@gmail.com", "admin123!"))
                .build();
    }

    //tc_01

    @Given("admin Goychak sets the url for POST request")
    public void admin_goychak_sets_the_url_for_post_request() {
        spec.pathParams("first", "categoriesKey", "second", 5, "third", "properties");
    }
    @Given("admin Goychak sets the expected data for the User")
    public void admin_goychak_sets_the_expected_data_for_the_user() {
        payload = new CategoryPropertyKeyPojo("BOOLEAN", "House", "a", "m2");
    }
    @When("admin Goychak sends the request and gets the response")
    public void admin_goychak_sends_the_request_and_gets_the_response() {
        response = given(spec).body(payload).when().post("{first}/{second}/{third}");
        response.prettyPrint();
    }
    @Then("admin Goychak verifies the status code is {int}")
    public void admin_goychak_verifies_the_status_code_is(int statusCode) {
        actualData = response.as(CategoryPropertyKeyPojo.class);
        System.out.println("actual = " + actualData);
        assertEquals("Status code does not match the expected value.", statusCode, response.getStatusCode());

    }
    @Then("admin Goychak verifies the response body")
    public void verifies_the_response_body() {
        assertEquals("Name does not match the expected value.", payload.getName(), actualData.getName());
        assertEquals("Key Type does not match the expected value.", payload.getKeyType(), actualData.getKeyType());
        assertEquals("Prefix code does not match the expected value.", payload.getPrefix(), actualData.getPrefix());
        assertEquals("Suffix code does not match the expected value.", payload.getSuffix(), actualData.getSuffix());

        // get id for other
        id = response.jsonPath().get("id");
        System.out.println(id);
    }

    //tc_02

    @Given("admin Goychak sets the url for GET request")
    public void admin_goychak_sets_the_url_for_get_request() {
        spec.pathParams("first", "categoriesKey", "second", 5, "third", "properties");
    }
    @Given("admin Goychak sets the expected data for the Get request")
    public void admin_goychak_sets_the_expected_data_for_the_get_request() {
        payload = new CategoryPropertyKeyPojo("BOOLEAN", "House", "a", "m2");
    }
    @When("admin Goychak sends the request and gets the Get response")
    public void admin_goychak_sends_the_request_and_gets_the_get_response() {
        response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();
        jsonPath = response.jsonPath();
        lastElement = (Map<String, Object>) jsonPath.getList("$").get(jsonPath.getList("$").size()-1);
    }
    @Then("admin Goychak verifies the status code of Get request is {int}")
    public void admin_goychak_verifies_the_status_code_of_get_request_is(int statusCode) {
        assertEquals("Status code does not match the expected value.", statusCode, response.getStatusCode());
    }
    @Then("admin Goychak verifies the response body of Get request")
    public void admin_goychak_verifies_the_response_body_of_get_request() {
        assertEquals("", payload.getName() , lastElement.get("name"));
        assertEquals("", payload.getKeyType(), lastElement.get("keyType"));
        assertEquals("", payload.getPrefix(), lastElement.get("prefix"));
        assertEquals("", payload.getSuffix(), lastElement.get("suffix"));
    }
}
