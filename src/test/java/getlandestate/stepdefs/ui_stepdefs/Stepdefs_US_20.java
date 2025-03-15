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

public class Stepdefs_US_20 {

    HomePage homePage = new HomePage();
    ContactPage contactPage = new ContactPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ContactMessagesPage contactMessagesPage = new ContactMessagesPage();

    @Given("Manager Natalia is on the {string} homepage")
    public void managerNataliaIsOnTheHomepage(String baseUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(baseUrl));
        WaitUtils.waitFor(5);
    }

    @When("manager Natalia clicks on Contact option")
    public void managerNataliaClicksOnContactOption() {
        homePage.contactOption.click();
        WaitUtils.waitFor(3);
    }

    @And("manager Natalia enters valid first name into First Name input field")
    public void managerNataliaEntersValidFirstNameIntoFirstNameInputField() {
        contactPage.contactFirstNameInput.sendKeys("Natalia");
    }

    @And("manager Natalia enters valid last name into Last Name input field")
    public void managerNataliaEntersValidLastNameIntoLastNameInputField() {
        contactPage.contactLastNameInput.sendKeys("Tarakci");
    }

    @And("manager Natalia enters valid email into Email Address input field")
    public void managerNataliaEntersValidEmailIntoEmailAddressInputField() {
        contactPage.contactEmailInput.sendKeys("nata@gmail.com");
    }

    @And("manager Natalia enters valid message into Message input field")
    public void managerNataliaEntersValidMessageIntoMessageInputField() {
        contactPage.contactMessageInput.sendKeys("Please contact me.");
    }

    @And("manager Natalia clicks on SEND button")
    public void managerNataliaClicksOnSENDButton() {
        contactPage.contactSendButton.click();
        WaitUtils.waitFor(8);
    }

    @And("manager Natalia clicks on Login option")
    public void managerNataliaClicksOnLoginOption() {
        homePage.loginOption.click();
        WaitUtils.waitFor(3);
    }

    @And("manager Natalia enters valid email into email input field")
    public void managerNataliaEntersValidEmailIntoEmailInputField() {
        loginPage.emailInput.sendKeys("manager_tarakci@gmail.com");
    }

    @And("manager Natalia enters valid password into password input field")
    public void managerNataliaEntersValidPasswordIntoPasswordInputField() {
        loginPage.passwordInput.sendKeys("Qw123nata+123");
        WaitUtils.waitFor(1);
    }

    @And("manager Natalia clicks on LOGIN button")
    public void managerNataliaClicksOnLOGINButton() {
        loginPage.login.click();
        WaitUtils.waitFor(5);
    }

    @And("manager Natalia clicks on ContactMessages section")
    public void managerNataliaClicksOnContactMessagesSection() {
        dashboardPage.contactMessagesSection.click();
        WaitUtils.waitFor(1);
    }

    @Then("manager Natalia should be able to see received contact messages in the list")
    public void managerNataliaShouldBeAbleToSeeReceivedContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("manager Natalia clicks on Filter icon")
    public void managerNataliaClicksOnFilterIcon() {
        contactMessagesPage.filterIcon.click();
    }

    @And("manager Natalia selects Unread option from Search In dropdown")
    public void managerNataliaSelectsUnreadOptionFromSearchInDropdown() {
        BrowserUtils.dropdownSelectByVisibleText(contactMessagesPage.searchInDropdown, "Unread");
    }

    @And("manager Natalia selects a date from the Start Date picker")
    public void managerNataliaSelectsADateFromTheStartDatePicker() {
        contactMessagesPage.startDatePicker.click();
        contactMessagesPage.startDatePicker.clear();
        contactMessagesPage.startDatePicker.sendKeys("01/03/2025");
        contactMessagesPage.startDatePicker.sendKeys(Keys.ENTER);
        WaitUtils.waitFor(1);
    }

    @And("manager Natalia selects a date from the End Date picker")
    public void managerNataliaSelectsADateFromTheEndDatePicker() {
        contactMessagesPage.endDatePicker.click();
        contactMessagesPage.endDatePicker.clear();
        contactMessagesPage.endDatePicker.sendKeys("31/03/2025");
        contactMessagesPage.endDatePicker.sendKeys(Keys.ENTER);
        WaitUtils.waitFor(1);
    }

    @And("manager Natalia clicks on Apply Filters button")
    public void managerNataliaClicksOnApplyFiltersButton() {
        contactMessagesPage.applyFiltersButton.click();
        WaitUtils.waitFor(2);
    }

    @Then("manager Natalia should be able to see filtered Unread contact messages in the list")
    public void managerNataliaShouldBeAbleToSeeFilteredUnreadContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("manager Natalia clicks on the filtered Unread contact message to view its details")
    public void managerNataliaClicksOnTheFilteredUnreadContactMessageToViewItsDetails() {
        contactMessagesPage.collapsedContactMessage.click();
    }

    @And("manager clicks on Mark as Read button")
    public void managerClicksOnMarkAsReadButton() {
        contactMessagesPage.markAsReadButton.click();
    }

    @Then("manager Natalia should be able to see the message marked as Read")
    public void manager_natalia_should_be_able_to_see_the_message_marked_as_read() throws IOException {
        WaitUtils.waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @And("manager Natalia selects Read option from Search In dropdown")
    public void managerNataliaSelectsReadOptionFromSearchInDropdown() {
        BrowserUtils.dropdownSelectByVisibleText(contactMessagesPage.searchInDropdown, "Read");
    }

    @Then("manager Natalia should be able to see filtered Read contact messages in the list")
    public void managerNataliaShouldBeAbleToSeeFilteredReadContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("manager Natalia clicks on the filtered Read contact message to view its details")
    public void managerNataliaClicksOnTheFilteredReadContactMessageToViewItsDetails() {
        contactMessagesPage.collapsedContactMessage.click();
    }

    @And("manager Natalia clicks on Delete message button")
    public void managerNataliaClicksOnDeleteMessageButton() {
        contactMessagesPage.deleteButton.click();
    }

    @Then("manager Natalia should be able to see the message deleted")
    public void managerNataliaShouldBeAbleToSeeTheMessageDeleted() throws IOException {
        WaitUtils.waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @And("manager Natalia closes the application")
    public void managerNataliaClosesTheApplication() {
        Driver.closeDriver();
    }

    @And("manager Natalia enters a keyword from a known message into Search input field")
    public void managerNataliaEntersAKeywordFromAKnownMessageIntoSearchInputField() {
        contactMessagesPage.searchInputBar.sendKeys("nata@gmail.com");
    }

    @And("manager Natalia clicks on Search icon")
    public void managerNataliaClicksOnSearchIcon() {
        contactMessagesPage.searchIcon.click();
        WaitUtils.waitFor(2);
    }

    @Then("manager Natalia should be able to see searched contact messages in the list")
    public void managerNataliaShouldBeAbleToSeeSearchedContactMessagesInTheList() {
        assertTrue(contactMessagesPage.collapsedContactMessage.isDisplayed());
    }

    @And("manager Natalia clicks on the searched contact message to view its details")
    public void managerNataliaClicksOnTheSearchedContactMessageToViewItsDetails() {
        contactMessagesPage.collapsedContactMessage.click();
    }
}
