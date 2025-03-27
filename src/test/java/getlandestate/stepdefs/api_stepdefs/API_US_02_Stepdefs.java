package getlandestate.stepdefs.api_stepdefs;

import getlandestate.pojos.CategoryPropertyKeyPojo;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.util.HashMap;
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
    private JsonPath jsonPath;
    private Map<String, Object> lastElement;
    private Map<String, Object> actualDataDelete;
    @Given("user Goychak is authorised as ADMIN")
    public void user_goychak_is_authorised_as_admin() {
        String baseUri = "http://64.227.123.49:8092";
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + generateToken("admin@gmail.com","admin123!"))
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
        System.out.println("================================");
        System.out.println(lastElement);
    }

    @Then("admin Goychak verifies the status code of Get request is {int}")
    public void admin_goychak_verifies_the_status_code_of_get_request_is(int statusCode) {
        assertEquals("Status code does not match the expected value.", statusCode, response.getStatusCode());
    }
    @Then("admin Goychak verifies the response body of Get request")
    public void admin_goychak_verifies_the_response_body_of_get_request() {
        assertEquals("Name does not match the expected value.", payload.getName() , lastElement.get("name"));
        assertEquals("Key type does not match the expected value.", payload.getKeyType(), lastElement.get("keyType"));
        assertEquals("Prefix does not match the expected value.", payload.getPrefix(), lastElement.get("prefix"));
        assertEquals("Suffix does not match the expected value.", payload.getSuffix(), lastElement.get("suffix"));
    }

/*    // tc_03
    @Given("admin Goychak sets the url for PUT request")
    public void admin_goychak_sets_the_url_for_put_request() {
        spec.pathParams("first", "categoriesKey", "second", "properties", "third", 531);
    }
    @Given("admin Goychak sets the expected data for the Put request")
    public void admin_goychak_sets_the_expected_data_for_the_put_request() {
        payloadPut = new HashMap<>();
        payloadPut.put("keyType", "Number");
        payloadPut.put("name", "Apartment");
        payloadPut.put("prefix", "a1");
        payloadPut.put("suffix", "m21");
    }
    @When("admin Goychak sends the request and gets the Put response")
    public void admin_goychak_sends_the_request_and_gets_the_put_response() {
        responsePut = given(spec).body(payloadPut).when().put("{first}/{second}/{third}");
        actualDataPut = responsePut.as(HashMap.class);
        System.out.println("================");
        System.out.println("responsePut.prettyPrint() = " + responsePut.prettyPrint());
    }
    @Then("admin Goychak verifies the status code of Put request is {int}")
    public void admin_goychak_verifies_the_status_code_of_put_request_is(int statusCode) {
       assertEquals("Status code does not match the expected value.", statusCode, responsePut.getStatusCode());
    }
    @Then("admin Goychak verifies the response body of Put request")
    public void admin_goychak_verifies_the_response_body_of_put_request() {
        assertEquals("Name does not match the expected value.", payloadPut.get("name"), actualDataPut.get("name"));
        assertEquals("Key type does not match the expected value.", payloadPut.get("keyType"), actualDataPut.get("keyType"));
        assertEquals("Prefix does not match the expected value.", payloadPut.get("prefix"), actualDataPut.get("prefix"));
        assertEquals("Suffix does not match the expected value.", payloadPut.get("suffix"), actualDataPut.get("suffix"));
    }*/

    // tc_03
    @Given("admin Goychak sets the url for DELETE request with id {int}")
    public void admin_goychak_sets_the_url_for_delete_request_with_id(int id) {
        spec.pathParams("first", "categoriesKey", "second", "properties", "third", id);
    }
    @When("admin Goychak sends the request and gets the Delete response")
    public void admin_goychak_sends_the_request_and_gets_the_delete_response() {
        response = given(spec).when().delete("{first}/{second}/{third}");
        actualDataDelete = response.as(HashMap.class);
//        System.out.println(actualDataDelete);
//        System.out.println("actualDataDelete.get(\"id\") = " + actualDataDelete.get("id"));
    }
    @Then("admin Goychak verifies the status code of Delete request is {int}")
    public void admin_goychak_verifies_the_status_code_of_delete_request_is(int statusCode) {
        assertEquals("Status code does not match the expected value.", statusCode, response.getStatusCode());
    }

    @Then("admin Goychak verifies the response body of Delete request contains id {int}")
    public void admin_goychak_verifies_the_response_body_of_delete_request_contains_id(int id) {
        assertEquals("Actual data does not contain the expected value.", actualDataDelete.get("id"), id);
    }
}