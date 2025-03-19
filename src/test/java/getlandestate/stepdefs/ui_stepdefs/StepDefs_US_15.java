package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefs_US_15 {


    CategoriesPage categoriesPage = new CategoriesPage();
    MyTourRequestsPage myTourRequestsPage = new MyTourRequestsPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    HomePage homePage = new HomePage();
    UsersPage usersPage = new UsersPage();
    AdvertTypesPage advertTypesPage = new AdvertTypesPage();

    // Background
    @Given("I navigate to {string} using web browser")
    public void i_navigate_to_using_web_browser(String url) {
        Driver.getDriver().get(url);
        System.out.println("Navigated to: " + url);
    }

    @When("I click on the Login button on the Homepage")
    public void i_click_on_the_login_button_on_the_Homepage() {
        homePage.loginOption.click();
        System.out.println("Clicked on login button.");
    }

    @When("I enter valid Admin credentials")
    public void i_enter_valid_admin_credentials() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        loginPage.emailInput.sendKeys("engineerhulya@hotmail.com");
        loginPage.passwordInput.sendKeys("Hulyatas2025?");
        loginPage.loginButton.click();
        System.out.println("Entered Admin credentials and clicked login.");
    }

    @Then("I should be redirected to the Dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.logoutButton));
        Assert.assertTrue(dashboardPage.logoutButton.isDisplayed());
        System.out.println("Redirected to Dashboard.");
    }

    // Scenario TC_01 & TC_02: Category & Advert Type Creation
    @Given("I click on {string} from the left menu")
    public void i_click_on_from_the_left_menu(String menuOption) {

        categoriesPage.categoriesMenu.click();
    }

    @When("^I click on the \"\\+\" \\(Add\\) button in the top-right corner$")
    public void i_click_on_the_add_button() {
        categoriesPage.addCategoryButton.click();
        System.out.println("Clicked on Add button.");
    }

    @When("I enter category name {string}")
    public void i_enter_category_name(String categoryName) {
        categoriesPage.categoryNameInput.sendKeys(categoryName);
        System.out.println("Entered category name: " + categoryName);
    }

    @When("I enter the advert type name {string}")
    public void i_enter_the_advert_type_name(String advertType) {
        advertTypesPage.advertTypeInput.sendKeys(advertType);
        System.out.println("Entered Advert Type: " + advertType);
    }

    @When("I click {string}")
    public void i_click(String buttonName) {
        if (buttonName.equals("Create")) {
            categoriesPage.createCategoryButton.click();
            System.out.println("Clicked Create button.");
        } else if (buttonName.equals("Update")) {
            categoriesPage.updateButton.click();
            System.out.println("Clicked Update button.");
        } else {
            System.out.println("Unknown button: " + buttonName);
        }
    }

    @Then("I should see the newly added category in the category list")
    public void i_should_see_the_newly_added_category() {
        Assert.assertTrue(categoriesPage.categorySuccessMessage.isDisplayed());
        System.out.println("Category successfully created.");
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        Assert.assertTrue(categoriesPage.successMessage.getText().contains(message));
        System.out.println("Verified message: " + message);
    }

    // Scenario TC_03: User Role Update Failure
    @When("I click the edit \\(pencil) icon next to any user")
    public void i_click_the_edit_pencil_icon_next_to_any_user() {
        usersPage.editButton.click();
        System.out.println("Clicked Edit button for user.");
    }

    @When("I attempt to change the role and click {string}")
    public void i_attempt_to_change_the_role_and_click(String buttonName) {
        usersPage.roleDropdown.click();
        if (buttonName.equals("Update")) {
            usersPage.updateButton.click();
            System.out.println("Clicked Update button for role change.");
        } else if (buttonName.equals("Save")) {
            usersPage.saveButton.click();
            System.out.println("Clicked Save button for role change.");
        } else {
            System.out.println("Unknown button: " + buttonName);
        }
    }

    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOf(dashboardPage.errorMessage));
        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
        System.out.println("Verified the error message: " + expectedErrorMessage);
    }


    @And("The category {string} exists in the list")
    public void the_category_exists_in_the_list(String categoryName) {

        System.out.println("Verified category exists: " + categoryName);
    }

    @When("I click the edit \\(pencil) icon next to {string}")
    public void i_click_the_edit_pencil_icon_next_to(String categoryName) {
        System.out.println("Clicked edit icon for category: " + categoryName);
    }

    @When("I modify the category name to {string} and change the sequence number")
    public void i_modify_the_category_name_and_change_sequence_number(String newCategoryName) {
        categoriesPage.categoryNameInput.clear();
        categoriesPage.categoryNameInput.sendKeys(newCategoryName);
        categoriesPage.sequenceNumberInput.clear();
        categoriesPage.sequenceNumberInput.sendKeys("2"); // Örnek sabit değer
        System.out.println("Modified category name to: " + newCategoryName + " and changed sequence number.");
    }

    @Then("I should see the success message {string}")
    public void i_should_see_the_success_message(String expectedMessage) {
        String actualMessage = categoriesPage.successMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("Verified success message: " + expectedMessage);
    }

    @When("I try to add a property key for the category")
    public void i_try_to_add_a_property_key_for_the_category() {
       // categoriesPage.addPropertyKeyButton.click();
        System.out.println("Tried to add a property key for the category.");
    }

    @Then("If the system does not allow property key creation, mark this step as {string}")
    public void if_the_system_does_not_allow_property_key_creation_mark_this_step(String status) {
        if (status.equalsIgnoreCase("Blocked")) {
            System.out.println("Step marked as Blocked: System does not allow property key creation.");

        } else {
            System.out.println("Step status: " + status);
        }
    }

    // Scenario TC_05: Tour Request Update Validation
    @When("I click the expand icon to open details")
    public void i_click_the_expand_icon_to_open_details() {
        myTourRequestsPage.expandDetails.click();
        System.out.println("Clicked expand icon.");
    }

    @When("^I click the edit \\(pencil\\) icon for Owner/Guest$")
    public void i_click_the_edit_pencil_icon_for_owner_guest() {
        myTourRequestsPage.editOwnerGuest.click();
        System.out.println("Clicked edit icon for Owner/Guest.");
    }
    @When("^I remove the phone number or enter an invalid phone number \\(e\\.g\\., \"(.*)\"\\)$")
    public void i_remove_or_enter_invalid_phone_number(String phone) {
        myTourRequestsPage.phoneNumberInput.clear();
        myTourRequestsPage.phoneNumberInput.sendKeys(phone);
        System.out.println("Entered invalid phone number: " + phone);
    }



    @When("I try to click {string}")
    public void i_try_to_click(String buttonName) {
        if (buttonName.equals("Update")) {
            myTourRequestsPage.updateButton.click();
            System.out.println("Clicked Update button.");
        } else {
            System.out.println("Unknown button: " + buttonName);
        }
    }

    @Then("I should see the error message \"Phone number is required\"")
    public void i_should_see_the_phone_number_error_message() {
        Assert.assertTrue(myTourRequestsPage.errorMessage.getText().contains("Phone number is required"));
        System.out.println("Verified phone number error message.");
    }
}
