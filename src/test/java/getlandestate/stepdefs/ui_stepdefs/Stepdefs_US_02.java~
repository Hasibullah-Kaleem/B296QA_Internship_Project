package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.HomePage;
import getlandestate.pages.LoginPage;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.Driver;
import getlandestate.utilities.MediaUtils;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Stepdefs_US_02 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("Customer Natalia is on the {string} home page")
    public void customerNataliaIsOnTheHomePage(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
        WaitUtils.waitFor(5);
    }

    @When("customer Natalia clicks on Login option")
    public void customerNataliaClicksOnLoginOption() {
        homePage.loginOption.click();
        WaitUtils.waitFor(3);
    }

    @And("customer Natalia enters valid email into email input field")
    public void customerNataliaEntersValidEmailIntoEmailInputField() {
        loginPage.emailInput.sendKeys("customer_tarakci@gmail.com");
    }

    @And("customer Natalia enters valid password into password input field")
    public void customerNataliaEntersValidPasswordIntoPasswordInputField() {
        loginPage.passwordInput.sendKeys("Qw123nata+123");
        WaitUtils.waitFor(5);
    }

    @And("customer Natalia clicks of LOGIN button")
    public void customerNataliaClicksOfLOGINButton() {
        if (loginPage.login.isEnabled()) {
            loginPage.login.click();
        }
        WaitUtils.waitFor(5);
    }

    @Then("customer Natalia should be able to login successfully")
    public void customerNataliaShouldBeAbleToLoginSuccessfully() {
        assertTrue(homePage.userPicture.isDisplayed());
    }

    @And("customer Natalia closes the application")
    public void customerNataliaClosesTheApplication() {
        Driver.closeDriver();
    }

    @And("customer Natalia enters invalid email into email input field")
    public void customerNataliaEntersInvalidEmailIntoEmailInputField() {
        loginPage.emailInput.sendKeys("customer_tarakci");
    }

    @Then("customer Natalia should not be able to login successfully with invalid email format")
    public void customerNataliaShouldNotBeAbleToLoginSuccessfullyWithInvalidEmailFormat() {
        assertTrue(loginPage.invalidEmailMessage.isDisplayed());
    }

    @Then("customer Natalia should not be able to login successfully without entering credentials")
    public void customerNataliaShouldNotBeAbleToLoginSuccessfullyWithoutEnteringCredentials() {
        assertTrue(loginPage.requiredEmailMessage.isDisplayed());
        assertTrue(loginPage.requiredPasswordMessage.isDisplayed());
    }
}
