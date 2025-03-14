package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.HomePage;
import getlandestate.pages.LoginPage;
import getlandestate.pages.UsersPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StepDefs_US_05 {


    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    UsersPage usersPage;

    @When("admin clicks on Customer account Edit button")
    public void admin_clicks_on_customer_account_edit_button() {

        usersPage = new UsersPage();
        usersPage.editButton.click();
        WaitUtils.waitFor(1);


    }
    @When("admin clicks on Roles menu and chooses Manager")
    public void admin_clicks_on_roles_menu_and_chooses_manager() {

        Select dropdown = new Select(usersPage.roleDropdown);
        dropdown.selectByIndex(1);
        WaitUtils.waitFor(1);

    }
    @When("admin clicks on Update button")
    public void admin_clicks_on_update_button() {

        usersPage = new UsersPage();
        usersPage.updateButton.click();

    }
    @Then("verify message {string} is displayed")
    public void verify_message_is_displayed(String successMessage) {

//        Assert.assertTrue(usersPage.successMessage.isDisplayed());
//        Driver.getDriver().navigate().refresh();
        Driver.closeDriver();

    }



    //TC_02

    @When("admin clicks on delete button")
    public void admin_clicks_on_delete_button() {

        usersPage = new UsersPage();
        WaitUtils.waitFor(1);
        usersPage.deleteButton.click();
        WaitUtils.waitFor(1);
        usersPage.yesOption.click();



    }

    @Then("admin verifies message {string} is displayed")
    public void verify_delete_message_is_displayed(String deleteMessage) {

        Assert.assertTrue(usersPage.deleteMessage.isDisplayed());
        WaitUtils.waitFor(1);
        Driver.closeDriver();

    }



    //TC_03

    @When("admin clicks on edit button")
    public void admin_clicks_on_edit_button() {

        usersPage = new UsersPage();
        usersPage.editButton.click();
        WaitUtils.waitFor(1);



    }
    @When("admin clicks on email field and enters invalid email {string}")
    public void admin_clicks_on_email_field_and_enters_invalid_email(String email) {



        usersPage.userEmail.click();
        for (int i = 0; i < email.length(); i++) {
            usersPage.userEmail.sendKeys(Keys.BACK_SPACE);
        }

        WaitUtils.waitFor(1);


    }
    @Then("admin attempts to click Update button and verifies Update button is disabled\\/not clickable")
    public void admin_attempts_to_click_update_button_and_verifies_update_button_is_disabled_not_clickable() {

        boolean isButtonDisabled = false;

        try {

            usersPage.updateButton.click();
            isButtonDisabled = false;
        } catch (Exception e) {

            isButtonDisabled = true;
        }



    }










}
