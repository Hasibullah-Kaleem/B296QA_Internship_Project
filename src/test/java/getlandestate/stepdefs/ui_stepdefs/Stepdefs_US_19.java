package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.ContactPage;
import getlandestate.pages.HomePage;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Stepdefs_US_19 {

    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();

    @Given("Customer Natalia is on the {string} homepage")
    public void customerNataliaIsOnTheHomepage(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
        WaitUtils.waitFor(5);
    }

    @When("customer Natalia clicks on Contact option")
    public void customerNataliaClicksOnContactOption() {
        homePage.contactOption.click();
        WaitUtils.waitFor(3);
    }

    @And("customer Natalia enters valid first name into First Name input field")
    public void customerNataliaEntersValidFirstNameIntoFirstNameInputField() {
        contactPage.contactFirstNameInput.sendKeys("Natalia");
    }

    @And("customer Natalia enters valid last name into Last Name input field")
    public void customerNataliaEntersValidLastNameIntoLastNameInputField() {
        contactPage.contactLastNameInput.sendKeys("Tarakci");
    }

    @And("customer Natalia enters valid email into Email Address input field")
    public void customerNataliaEntersValidEmailIntoEmailAddressInputField() {
        contactPage.contactEmailInput.sendKeys("nata@gmail.com");
    }

    @And("customer Natalia enters valid message into Message input field")
    public void customerNataliaEntersValidMessageIntoMessageInputField() {
        contactPage.contactMessageInput.sendKeys("Please contact me.");
    }

    @And("customer Natalia clicks on SEND button")
    public void customerNataliaClicksOnSENDButton() {
        if (contactPage.contactSendButton.isEnabled()){
            contactPage.contactSendButton.click();
        }
        WaitUtils.waitFor(2);
    }

    @Then("customer Natalia should be able to send a message successfully with valid data")
    public void customerNataliaShouldBeAbleToSendAMessageSuccessfullyWithValidData() {
        assertTrue(contactPage.contactSuccessMessage.isDisplayed());
    }

    @And("customer Natalia closes the Application")
    public void customerNataliaClosesTheApplication() {
        Driver.closeDriver();
    }

    @And("customer Natalia enters invalid first name into First Name input field")
    public void customerNataliaEntersInvalidFirstNameIntoFirstNameInputField() {
        contactPage.contactFirstNameInput.sendKeys("N");
    }

    @Then("customer Natalia should not be able to send a message with invalid first name")
    public void customerNataliaShouldNotBeAbleToSendAMessageWithInvalidFirstName() {
        assertTrue(contactPage.contactNameWarningMessage.isDisplayed());
    }

    @And("customer Natalia enters invalid last name into Last Name input field")
    public void customerNataliaEntersInvalidLastNameIntoLastNameInputField() {
        contactPage.contactLastNameInput.sendKeys("T");
    }

    @Then("customer Natalia should not be able to send a message with invalid last name")
    public void customerNataliaShouldNotBeAbleToSendAMessageWithInvalidLastName() {
        assertTrue(contactPage.contactNameWarningMessage.isDisplayed());
    }

    @And("customer Natalia enters invalid email into Email Address input field")
    public void customerNataliaEntersInvalidEmailIntoEmailAddressInputField() {
        contactPage.contactEmailInput.sendKeys("nata");
    }

    @Then("customer Natalia should not be able to send a message with invalid email format")
    public void customerNataliaShouldNotBeAbleToSendAMessageWithInvalidEmailFormat() {
        assertTrue(contactPage.contactEmailWarningMessage.isDisplayed());
    }
}
