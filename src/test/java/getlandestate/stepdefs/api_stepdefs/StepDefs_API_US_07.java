package getlandestate.stepdefs.api_stepdefs;

import getlandestate.pojos.ReportControllerPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static getlandestate.baseurl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefs_API_US_07 {

    private Response response;
    private ReportControllerPojo expectedData;
    private ReportControllerPojo actualData;

    @And("the users sets the url for Get the general report of total adverts, users, advert types, tour requests and categorie for API_US_7")
    public void theUsersSetsTheUrlForReport() {
        if (spec == null) {
            throw new IllegalStateException("❌ BaseUrl.spec is NULL. Ensure you execute BaseUrl.setUp(email, password) before any API call.");
        }
        spec.pathParam("first", "report");
    }

    @And("the user sets the expected data for the the general report")
    public void theUserSetsTheExpectedDataForGeneralReport() {
        // These values should be fetched dynamically (e.g., from a database or config file)
        expectedData = new ReportControllerPojo(200, 507, 249, 131, 27);
    }

    @When("the user sends a GET request to the report api and gets the response")
    public void theUserSendsAGETRequestToReportAPI() {
        response = given(spec)
                .when()
                .get("{first}");

        response.prettyPrint();

        actualData = response.as(ReportControllerPojo.class);
    }

    @Then("the response status code is {int} for API_US_7")
    public void theResponseStatusCodeIsForAPI_US_7(int statusCode) {
        Assert.assertEquals(200, response.getStatusCode());
    }


    @And("the user verifies the response data for the the general report for API_US_7")
    public void theUserVerifiesTheResponseDataForAPI_US_7() {
        assertEquals("❌ totalAdverts mismatch!", expectedData.getTotalAdverts(), actualData.getTotalAdverts());
        assertEquals("❌ totalUsers mismatch!", expectedData.getTotalUsers(), actualData.getTotalUsers());
        assertEquals("❌ totalAdvertTypes mismatch!", expectedData.getTotalAdvertTypes(), actualData.getTotalAdvertTypes());
        assertEquals("❌ totalTourRequests mismatch!", expectedData.getTotalTourRequests(), actualData.getTotalTourRequests());
        assertEquals("❌ totalCategories mismatch!", expectedData.getTotalCategories(), actualData.getTotalCategories());

        System.out.println("✅ All values match the expected response!");
    }
}
