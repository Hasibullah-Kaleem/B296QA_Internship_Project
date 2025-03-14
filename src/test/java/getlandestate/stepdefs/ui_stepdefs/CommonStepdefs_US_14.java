package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonStepdefs_US_14 {

    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    PropertiesPage propertiesPage;
    @Given("User navigates to {string} using a web browser")
    public void userNavigatesToUsingAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("User clicks on the Login button on the homepage")
    public void userClicksOnTheLoginButtonOnTheHomepage() {
        homePage = new HomePage();
        homePage.loginOption.click();
    }

    @And("User enters valid manager credentials with {string} and {string} in the login form")
    public void userEntersValidManagerCredentialsWithAndInTheLoginForm(String email, String password) {
        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    @And("User clicks on the Login button at the top-right corner of the website to authenticate")
    public void userClicksOnTheLoginButtonAtTheTopRightCornerOfTheWebsiteToAuthenticate() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(2);
    }

    @And("User clicks on the Back to Site tab located on the left side of the dashboard")
    public void userClicksOnTheBackToSiteTabLocatedOnTheLeftSideOfTheDashboard() {
        controlPanelPage = new ControlPanelPage();
        controlPanelPage.backToSite.click();
        WaitUtils.waitFor(2);
    }

    @And("User clicks on the Properties tab at the top of the website")
    public void userClicksOnThePropertiesTabAtTheTopOfTheWebsite() {
        homePage.propertiesOption.click();
    }

    @And("User selects the first house displayed on the page and clicks on it")
    public void userSelectsTheFirstHouseDisplayedOnThePageAndClicksOnIt() {
        propertiesPage = new PropertiesPage();
        propertiesPage.property.click();
        WaitUtils.waitFor(2);
    }

}
