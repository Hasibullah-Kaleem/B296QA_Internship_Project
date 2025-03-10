package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepdefs_US_18 {

    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    MyTourRequestsPage myTourRequestsPage;

    @Given("I navigate to {string} with a web browser")
    public void iNavigateToUsingAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("I click on the Login button on the homepage")
    public void iClickOnTheLoginButtonOnTheHomepage() {
        homePage = new HomePage();
        homePage.loginOption.click();
    }

    @And("I enter valid manager credentials using the username {string} and the password {string}")
    public void iEnterValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    @And("I click on the Reports button at the right side of the dashboard")
    public void iClickOnTheReportsButtonAtTheRightSideOfTheDashboard() {
        ReportsPage reportsPage = new ReportsPage();
        reportsPage.reportSectionButton.click();
    }

    @And("I click on the Back to Site tab on the left side of the dashboard to go back to the homepage")
    public void iClickOnTheBackToSiteTabOnTheLeftSideOfTheDashboard() {
        controlPanelPage.backToSite.click();
    }
}
