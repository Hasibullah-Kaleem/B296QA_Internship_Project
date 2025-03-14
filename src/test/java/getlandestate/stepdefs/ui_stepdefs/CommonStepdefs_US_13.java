package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.HomePage;
import getlandestate.pages.LoginPage;
import getlandestate.pages.MyTourRequestsPage;
import getlandestate.utilities.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import javax.swing.*;

public class CommonStepdefs_US_13 {


    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    MyTourRequestsPage myTourRequestsPage;
    @Given("I navigate to {string} using a web browser")
    public void iNavigateToUsingAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }


    @And("I enter valid manager credentials with username {string} and password {string}")
    public void iEnterValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    @And("I click on the Login button at the top-right corner of the website")
    public void iClickOnTheLoginButtonAtTheTopRightCornerOfTheWebsite() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(2);
    }

    @And("I click on the Back to Site tab on the left side of the dashboard")
    public void iClickOnTheBackToSiteTabOnTheLeftSideOfTheDashboard() {
        controlPanelPage = new ControlPanelPage();
        controlPanelPage.backToSite.click();
        WaitUtils.waitFor(2);
    }

    @And("I click on the User Profile button at the top-right corner of the website")
    public void iClickOnTheUserProfileButtonAtTheTopRightCornerOfTheWebsite() {
        homePage.userProfile.click();
        WaitUtils.waitFor(2);
    }

    @And("I navigate to the My Tour Requests tab from the dropdown menu")
    public void iNavigateToTheMyTourRequestsTabFromTheDropdownMenu() {
        homePage.myTourRequests.click();
        WaitUtils.waitFor(2);
    }

    @And("I go to the My Responses section")
    public void iGoToTheMyResponsesSection() {
        myTourRequestsPage = new MyTourRequestsPage();
        myTourRequestsPage.myResponesTab.click();
        WaitUtils.waitFor(3);
    }

}
