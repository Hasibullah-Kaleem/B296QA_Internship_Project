package getlandestate.stepdefs.ui_stepdefs;
/*
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

    @Given("I open {string} in a web browser")
    public void iOpenInAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("I select the Login button on the homepage")
    public void iSelectTheLoginButtonOnTheHomepage() {
        homePage = new HomePage();
        homePage.loginOption.click();
    }

    @And("I provide valid manager credentials with username {string} and password {string}")
    public void iProvideValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    @And("I navigate back to the homepage by clicking the Back to Site tab on the left side of the dashboard")
    public void iNavigateBackToTheHomepageByClickingTheBackToSiteTabOnTheLeftSideOfTheDashboard() {
        controlPanelPage.backToSite.click();
    }
}


import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepdefs_US_18 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();

    @Given("I open {string} in a web browser")
    public void iOpenInAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("I select the Login button on the homepage")
    public void iSelectTheLoginButtonOnTheHomepage() {
        homePage.loginOption.click();
    }

    @And("I provide valid manager credentials with username {string} and password {string}")
    public void iProvideValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    @And("I navigate back to the homepage by clicking the Back to Site tab on the left side of the dashboard")
    public void iNavigateBackToTheHomepageByClickingTheBackToSiteTabOnTheLeftSideOfTheDashboard() {
        controlPanelPage.backToSite.click();
    }
}
*/