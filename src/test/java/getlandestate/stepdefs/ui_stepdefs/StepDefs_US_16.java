package getlandestate.stepdefs.ui_stepdefs;
import getlandestate.pages.DashboardPage;

import getlandestate.pages.LoginPage;
import getlandestate.pages.ReportsPage;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.Driver;
import getlandestate.utilities.MediaUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.String;
import java.time.Duration;

import static getlandestate.utilities.MediaUtils.*;
import static getlandestate.utilities.WaitUtils.waitFor;

import static org.junit.Assert.assertTrue;

public class StepDefs_US_16 {


    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait;
    LoginPage loginPage = new LoginPage();
    ReportsPage reportsPage = new ReportsPage();
    Actions actions = new Actions(Driver.getDriver());

    public StepDefs_US_16() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)); // 10 saniye bekleme süresi
    }


    @Given("Admin opens {string} in a browser")
    public void admin_opens_in_a_browser(String string) {
        String baseUrl = ConfigReader.getProperty("baseUrl");
        System.out.println(" Navigating to: " + baseUrl);
        Driver.getDriver().get(baseUrl);


    }

    @When("Admin clicks the login button on the homepage")
    public void admin_clicks_the_login_button_on_the_homepage() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
        loginPage.loginButton.click();
        System.out.println("[Login button clicked.");
    }


    @And("Admin enters valid credentials with username {string} and password {string}")
    public void admin_enters_valid_credentials_with_username_and_password(String username, String password) {
        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn)).click();
        wait.until(ExpectedConditions.urlContains("dashboard"));
        System.out.println("[INFO] Login successful, redirected to dashboard.");
    }


    @And("Admin navigates to the Reports section from the dashboard")
    public void admin_navigates_to_the_reports_section_from_the_dashboard() {
        wait.until(ExpectedConditions.visibilityOf(reportsPage.reportSectionButton));
        reportsPage.reportSectionButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(reportsPage.reportSectionButton)).click();
    }

    @Given("Admin configures the report filters with start date, end date, category, advert type, and status")
    public void admin_configures_the_report_filters_with_start_date_end_date_category_advert_type_and_status() throws IOException {


       reportsPage.startDate1.sendKeys("05/05/2025");
       reportsPage.endDate1.sendKeys("20/09/2025");
        reportsPage.selectCategory.click();
        actions.sendKeys(Keys.ENTER).perform();
        reportsPage.selectAdvertType.click();
        actions.sendKeys(Keys.ENTER).perform();
        reportsPage.selectStatus.click();
        reportsPage.selectStatusApproved1.click();
        waitFor(1);
        takeScreenshotOfTheEntirePage();

    }

    @When("Admin clicks on the Generate Advertisement Report button")
    public void admin_clicks_on_the_generate_advertisement_report_button() throws IOException {
        reportsPage.reportButton1Adverts.click();

        takeScreenshotOfTheEntirePage();


    }

    @Then("The report should be successfully generated")
    public void the_report_should_be_successfully_generated() throws IOException {
        System.out.println("Report successfully generated!");

        String expectedMessage = "Report successfully exported to excel file";

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage));
        String actualMessage = successMessage.getText();
        assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage))
                .getText().contains("Report successfully exported to excel file"));
        takeScreenshotOfTheEntirePage();

        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));

        dashboardPage.logoutButton.click();
        actions.sendKeys(Keys.ENTER).perform();

    }


    @Given("Admin sets the report parameters based on the amount filter")
    public void admin_sets_report_parameters_amount() {
        System.out.println("Setting report filters for popular adverts...");
        reportsPage.amount.sendKeys("1");


    }

    @When("Admin triggers the report generation for popular adverts")
    public void admin_triggers_report_generation_for_popular_adverts() throws IOException {

        wait.until(ExpectedConditions.elementToBeClickable(reportsPage.reportButton2MostPopularProperties)).click();


        actions.moveToElement(reportsPage.reportButton2MostPopularProperties).click().perform();


        takeScreenshotOfTheEntirePage();

        System.out.println("The report for popular adverts is now being generated...");
    }

    @Given("Admin sets the report parameters for user roles")
    public void admin_sets_report_parameters_user_roles() {
        System.out.println("Setting report filters for user roles...");

        reportsPage.selectRole.click();
        reportsPage.selectRoleAdmin.click();
        actions.sendKeys(Keys.ENTER).perform();

    }

    @When("Admin clicks on the Generate Role-Based Report button")
    public void admin_clicks_generate_role_based_report() throws IOException {
        System.out.println("Generating role-based report...");
        reportsPage.reportButton3Users.click();
        takeScreenshotOfTheEntirePage();
    }

    @Given("Admin configures the report filters using start date, end date, and status")
    public void admin_configures_report_filters_tour_request() throws IOException {
        System.out.println("Setting report filters for tour requests...");
        reportsPage.startDate2.sendKeys("05/05/2025");
        reportsPage.endDate2.sendKeys("20/09/2025");
        reportsPage.selectStatus.click();
        reportsPage.selectStatusApproved1.click();
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @When("Admin clicks on the Generate Tour Request Report button")
    public void admin_clicks_generate_tour_request_report() throws IOException {
        System.out.println("Generating tour request report...");
        reportsPage.reportButton4TourRequests.click();

        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Then("The report should be exported successfully")
    public void report_should_be_exported_successfully() throws IOException {
        System.out.println("Full authentication is required to access this resource!");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


        WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage));
        String actualMessage = successMessage.getText();
        System.out.println("expectedMessage: " + actualMessage);

        String expectedMessage = ConfigReader.getProperty("expectedMessage");

        assertTrue(actualMessage.contains(expectedMessage));

        MediaUtils.takeScreenshotOfTheEntirePage();
    }





    }

