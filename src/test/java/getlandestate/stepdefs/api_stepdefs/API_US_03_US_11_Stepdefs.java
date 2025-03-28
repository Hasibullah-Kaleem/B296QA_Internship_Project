package getlandestate.stepdefs.api_stepdefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import getlandestate.pojos.advert_controller.AdvertsCitiesLimitPojo;
import getlandestate.pojos.daily_report_controller.DailyReportPojo;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import java.util.List;

import static getlandestate.hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class API_US_03_US_11_Stepdefs {

    private Response response;

    @Given("the API endpoint {string} is available")
    public void theAPIEndpointIsAvailable(String endpoint) {
        // Base URI is already set in Hook class
    }

    @When("Admin Natalia sends a GET request to the daily-report endpoint")
    public void adminNataliaSendsAGETRequestToTheDailyReportEndpoint() {
        spec.pathParams("first", "daily-report"); // Using predefined spec from Hook class
        response = given(spec)
                .when()
                .get("{first}");
    }

    @When("Admin Natalia sends a GET request to the adverts endpoint")
    public void adminNataliaSendsAGETRequestToTheAdvertsEndpoint() {
        spec.pathParams("first", "adverts", "second", "cities", "third", "1"); // Using predefined spec from Hook class
        response = given(spec)
                .when()
                .get("{first}/{second}/{third}");
    }

    @Then("Admin Natalia verifies that the response status code is {int}")
    public void adminNataliaVerifiesThatTheResponseStatusCodeIs(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.statusCode());
    }

    @And("Admin Natalia verifies that the response body matches the expected data")
    public void adminNataliaVerifiesThatTheResponseBodyMatchesTheExpectedData() {
        AdvertsCitiesLimitPojo expectedData = new AdvertsCitiesLimitPojo(3815, "Bristol", 10);
        // Deserialize response into a list
        List<AdvertsCitiesLimitPojo> actualDataList = response.jsonPath().getList("", AdvertsCitiesLimitPojo.class);

        // Validate the first match
        assertNotNull(actualDataList);
        assertFalse(actualDataList.isEmpty());

        AdvertsCitiesLimitPojo actualData = actualDataList.get(0); // Get the first object

        assertEquals(expectedData.getCityId(), actualData.getCityId());
        assertEquals(expectedData.getCityName(), actualData.getCityName());
        assertEquals(expectedData.getCityQuantity(), actualData.getCityQuantity());
    }

    @And("Admin Natalia verifies that the response body of the {string} API matches the expected structure")
    public void adminNataliaVerifiesThatTheResponseBodyOfTheAPIMatchesTheExpectedStructure(String endpoint) throws JsonProcessingException {

        // Deserialize response to DailyReportResponse POJO
        ObjectMapper objectMapper = new ObjectMapper();
        DailyReportPojo dailyReportPojo = objectMapper.readValue(response.asString(), DailyReportPojo.class);
        System.out.println("dailyReportResponse.getContactMessages() = " + dailyReportPojo.getContactMessages());

        // Validation - Ensure key fields exist
        assertNotNull("ContactMessages data is missing!", dailyReportPojo.getContactMessages());
        assertNotNull("Favorites data is missing!", dailyReportPojo.getFavorites());
        assertNotNull("RentAdverts data is missing!", dailyReportPojo.getRentAdverts());
        assertNotNull("SaleAdverts data is missing!", dailyReportPojo.getSaleAdverts());
        assertNotNull("TourRequests data is missing!", dailyReportPojo.getTourRequests());
        assertNotNull("Users data is missing!", dailyReportPojo.getUsers());

        // Additional validation (checking if each key contains non-empty data)
        assertFalse("ContactMessages should not be empty!", dailyReportPojo.getContactMessages().isEmpty());
        assertFalse("Favorites should not be empty!", dailyReportPojo.getFavorites().isEmpty());
        assertFalse("RentAdverts should not be empty!", dailyReportPojo.getRentAdverts().isEmpty());
        assertFalse("SaleAdverts should not be empty!", dailyReportPojo.getSaleAdverts().isEmpty());
        assertFalse("TourRequests should not be empty!", dailyReportPojo.getTourRequests().isEmpty());
        assertFalse("Users should not be empty!", dailyReportPojo.getUsers().isEmpty());
    }

}
