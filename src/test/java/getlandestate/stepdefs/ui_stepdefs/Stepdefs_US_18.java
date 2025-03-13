package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.HomePage;
import getlandestate.pages.LoginPage;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefs_US_18 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();

    @Given("I open {string} with a web browser")
    public void iOpenInAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("I select the Login button on the homepage to login")
    public void iSelectTheLoginButtonOnTheHomepageToLogin() {
        homePage.loginOption.click();
    }

    @And("I give valid manager credentials with username {string} and password {string}")
    public void iGiveValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @And("I navigate back to the homepage by clicking the Back to Site tab on the left side of the dashboard")
    public void iNavigateBackToTheHomepageByClickingTheBackToSiteTabOnTheLeftSideOfTheDashboard() {
        controlPanelPage.backToSite.click();
    }

    //TC_01
    @Given("I click on the properties tab on the homepage to see properties available")
    public void iClickOnThePropertiesTabOnTheHomepageToSeePropertiesAvailable() {
    }

    @And("I choose a property to view")
    public void iChooseAPropertyToView() {
    }

    @And("I choose a Tour date and time")
    public void iChooseATourDateAndTime() {
    }

    @And("I click on the submit a tour request button")
    public void iClickOnTheSubmitATourRequestButton() {
    }

    @Then("I should see a message that the tour request has been submitted successfully")
    public void iShouldSeeAMessageThatTheTourRequestHasBeenSubmittedSuccessfully() {
    }

    //TC_02
    @And("I navigate to the My Adverts tab from the dropdown menu")
    public void iNavigateToTheMyAdvertsTabFromTheDropdownMenu() {
    }

    @And("I choose a property to view from my own adverts")
    public void iChooseAPropertyToViewFromMyOwnAdverts() {
    }
}
