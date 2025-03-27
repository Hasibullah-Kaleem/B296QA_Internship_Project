package getlandestate.stepdefs.api_stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static getlandestate.baseurl.BaseUrl.spec;

public class StepDefs_API_US_07 {


    @And("the users sets the url for Get the general report of total adverts, users, advert types, tour requests and categorie for API_US_{int}")
    public void theUsersSetsTheUrlForGetTheGeneralReportOfTotalAdvertsUsersAdvertTypesTourRequestsAndCategorieForAPI_US_(int id) {

        if (spec == null) {
            throw new IllegalStateException("❌ BaseUrl.spec is NULL. Ensure BaseUrl.setUp(email, password) is called before API requests.");
        }
       // http://64.227.123.49:8092/report
        // Setting path parameters and query parameters
        spec.pathParam("first", "report");

    }




    @And("the user sets the expected data for the the general report")
    public void theUserSetsTheExpectedDataForTheTheGenralReport() {
    }

    @When("the user sends a GET request to the report api and gets the response")
    public void theUserSendsAGETRequestToTheReportApiAndGetsTheResponse() {
    }
}
