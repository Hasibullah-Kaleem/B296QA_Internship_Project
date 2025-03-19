package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Stepdefs_US_21 {

    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ContactMessagesPage contactMessagesPage = new ContactMessagesPage();

    @Given("Admin Natalia is on the {string} homepage")
    public void adminNataliaIsOnTheHomepage(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
        WaitUtils.waitFor(5);
    }

    @When("admin Natalia clicks on Contact option")
    public void adminNataliaClicksOnContactOption() {
        homePage.contactOption.click();
        WaitUtils.waitFor(3);
    }

    @And("admin Natalia enters valid first name into First Name input field")
    public void adminNataliaEntersValidFirstNameIntoFirstNameInputField() {
        contactPage.contactFirstNameInput.sendKeys("Natalia");
    }

    @And("admin Natalia enters valid last name into Last Name input field")
    public void adminNataliaEntersValidLastNameIntoLastNameInputField() {
        contactPage.contactLastNameInput.sendKeys("Tarakci");
    }

    @And("admin Natalia enters valid email into Email Address input field")
    public void adminNataliaEntersValidEmailIntoEmailAddressInputField() {
        contactPage.contactEmailInput.sendKeys("nata@gmail.com");
    }

    @And("admin Natalia enters valid message into Message input field")
    public void adminNataliaEntersValidMessageIntoMessageInputField() {
        contactPage.contactMessageInput.sendKeys("Please contact me.");
    }

    @And("admin Natalia clicks on SEND button")
    public void adminNataliaClicksOnSENDButton() {
        contactPage.contactSendButton.click();
        WaitUtils.waitFor(8);
    }

    @And("admin Natalia clicks on Login option")
    public void adminNataliaClicksOnLoginOption() {
        homePage.loginOption.click();
        WaitUtils.waitFor(3);
    }

    @And("admin Natalia enters valid email into email input field")
    public void adminNataliaEntersValidEmailIntoEmailInputField() {
        loginPage.emailInput.sendKeys("admin_tarakci@gmail.com");
    }

    @And("admin Natalia enters valid password into password input field")
    public void adminNataliaEntersValidPasswordIntoPasswordInputField() {
        loginPage.passwordInput.sendKeys("Qw123nata+123");
        WaitUtils.waitFor(1);
    }

    @And("admin Natalia clicks on LOGIN button")
    public void adminNataliaClicksOnLOGINButton() {
        loginPage.login.click();
        WaitUtils.waitFor(5);
    }

    @And("admin Natalia clicks on ContactMessages section")
    public void adminNataliaClicksOnContactMessagesSection() {
        dashboardPage.contactMessagesSection.click();
        WaitUtils.waitFor(1);
    }

    @Then("admin Natalia should be able to see received contact messages in the list")
    public void adminNataliaShouldBeAbleToSeeReceivedContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("admin Natalia clicks on Filter icon")
    public void adminNataliaClicksOnFilterIcon() {
        contactMessagesPage.filterIcon.click();
    }

    @And("admin Natalia selects Unread option from Search In dropdown")
    public void adminNataliaSelectsUnreadOptionFromSearchInDropdown() {
        BrowserUtils.dropdownSelectByVisibleText(contactMessagesPage.searchInDropdown, "Unread");
    }

    @And("admin Natalia selects a date from the Start Date picker")
    public void adminNataliaSelectsADateFromTheStartDatePicker() {
        contactMessagesPage.startDatePicker.click();
        contactMessagesPage.startDatePicker.clear();
        contactMessagesPage.startDatePicker.sendKeys("01/03/2025");
        contactMessagesPage.startDatePicker.sendKeys(Keys.ENTER);
        WaitUtils.waitFor(1);
    }

    @And("admin Natalia selects a date from the End Date picker")
    public void adminNataliaSelectsADateFromTheEndDatePicker() {
        contactMessagesPage.endDatePicker.click();
        contactMessagesPage.endDatePicker.clear();
        contactMessagesPage.endDatePicker.sendKeys("31/03/2025");
        contactMessagesPage.endDatePicker.sendKeys(Keys.ENTER);
        WaitUtils.waitFor(1);
    }

    @And("admin Natalia clicks on Apply Filters button")
    public void adminNataliaClicksOnApplyFiltersButton() {
        contactMessagesPage.applyFiltersButton.click();
        WaitUtils.waitFor(2);
    }

    @Then("admin Natalia should be able to see filtered Unread contact messages in the list")
    public void adminNataliaShouldBeAbleToSeeFilteredUnreadContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("admin Natalia clicks on the filtered Unread contact message to view its details")
    public void adminNataliaClicksOnTheFilteredUnreadContactMessageToViewItsDetails() {
        contactMessagesPage.collapsedContactMessage.click();
    }

    @And("admin clicks on Mark as Read button")
    public void adminClicksOnMarkAsReadButton() {
        contactMessagesPage.markAsReadButton.click();
    }

    @Then("admin Natalia should be able to see the message marked as Read")
    public void adminNataliaShouldBeAbleToSeeTheMessageMarkedAsRead() throws IOException {
        WaitUtils.waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @And("admin Natalia selects Read option from Search In dropdown")
    public void adminNataliaSelectsReadOptionFromSearchInDropdown() {
        BrowserUtils.dropdownSelectByVisibleText(contactMessagesPage.searchInDropdown, "Read");
    }

    @Then("admin Natalia should be able to see filtered Read contact messages in the list")
    public void adminNataliaShouldBeAbleToSeeFilteredReadContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("admin Natalia clicks on the filtered Read contact message to view its details")
    public void adminNataliaClicksOnTheFilteredReadContactMessageToViewItsDetails() {
        contactMessagesPage.collapsedContactMessage.click();
    }

    @And("admin Natalia clicks on Delete message button")
    public void adminNataliaClicksOnDeleteMessageButton() {
        contactMessagesPage.deleteButton.click();
    }

    @Then("admin Natalia should be able to see the message deleted")
    public void adminNataliaShouldBeAbleToSeeTheMessageDeleted() throws IOException {
        WaitUtils.waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @And("admin Natalia closes the application")
    public void adminNataliaClosesTheApplication() {
        Driver.closeDriver();
    }

    @And("admin Natalia enters a keyword from a known message into Search input field")
    public void adminNataliaEntersAKeywordFromAKnownMessageIntoSearchInputField() {
        contactMessagesPage.searchInputBar.sendKeys("nata@gmail.com");
    }

    @And("admin Natalia clicks on Search icon")
    public void adminNataliaClicksOnSearchIcon() {
        contactMessagesPage.searchIcon.click();
        WaitUtils.waitFor(2);
    }

    @Then("admin Natalia should be able to see searched contact messages in the list")
    public void adminNataliaShouldBeAbleToSeeSearchedContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("admin Natalia clicks on the searched contact message to view its details")
    public void adminNataliaClicksOnTheSearchedContactMessageToViewItsDetails() {
        contactMessagesPage.collapsedContactMessage.click();
    }
}
