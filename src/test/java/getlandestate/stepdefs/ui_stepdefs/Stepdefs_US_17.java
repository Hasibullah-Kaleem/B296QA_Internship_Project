package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import getlandestate.utilities.JSUtils;
import getlandestate.utilities.MediaUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static getlandestate.utilities.WaitUtils.waitFor;
import static org.junit.Assert.assertTrue;

public class Stepdefs_US_17 {

    ReportsPage myReportsPage = new ReportsPage();
    ManagerPage myManagerPage = new ManagerPage();
    ControlPanelPage myControlPanelPage = new ControlPanelPage();
    DashboardPage myDashboardPage = new DashboardPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait;

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ReportsPage reportsPage = new ReportsPage();

    @Given("I open {string} in a web browser")
    public void iOpenInAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("I select the Login button on the homepage")
    public void iSelectTheLoginButtonOnTheHomepage() {
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));
        homePage.loginOption.click();
    }

    @And("I provide valid manager credentials with username {string} and password {string}")
    public void iProvideValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @And("I click on the Reports button at the right side of the dashboard")
    public void iClickOnTheReportsButtonAtTheRightSideOfTheDashboard() {
        reportsPage.reportSectionButton.click();
    }


    //TC_01
    @Given("I set the parameters for the report generation based on the start date, end date, category, advert type, and status")
    public void iSetTheParametersForTheReportGenerationBasedOnTheStartDateEndDateCategoryAdvertTypeAndStatus() throws IOException {
        myReportsPage.startDate1.sendKeys("01/01/2025");
        myReportsPage.endDate1.sendKeys("10/03/2025");
        myReportsPage.selectCategory.click();
        actions.sendKeys(Keys.ENTER).perform();
        myReportsPage.selectAdvertType.click();
        actions.sendKeys(Keys.ENTER).perform();
        myReportsPage.selectStatus.click();
        myReportsPage.selectStatusApproved1.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();

    }

    @When("I click on the Generate Adverts Report button")
    public void iClickOnTheGenerateAdvertsReportButton() throws IOException {
        myReportsPage.reportButton1Adverts.click();

        MediaUtils.takeScreenshotOfTheEntirePage();

    }

    @Then("I should see the report generated successfully")
    public void iShouldSeeTheReportGeneratedSuccessfully() throws InterruptedException, IOException {

        String expectedMessage = "Report successfully exported to excel file";
// Wait until the toast notification is visible
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage));
// Get the actual text of the toast message
        String actualMessage = toastMessage.getText();
        System.out.println("✅ Toast Message: " + actualMessage);
// Assert that the actual message contains the expected message
        assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).getText().contains("Report successfully exported to excel file"));
// assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).isDisplayed());

        MediaUtils.takeScreenshotOfTheEntirePage();

        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        myDashboardPage.logoutButton.click();
        actions.sendKeys(Keys.ENTER).perform();
    }


    //TC_02
    @Given("I set the parameters for the report generation based on the amount")
    public void iSetTheParametersForTheReportGenerationBasedOnTheAmount() {

        myReportsPage.amount.sendKeys("1");
    }

    @When("I click on the Generate popular Adverts Report button")
    public void iClickOnTheGeneratePopularAdvertsReportButton() throws IOException {
        myReportsPage.reportButton2MostPopularProperties.click();

        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Then("I should see the report generated successfully for amount-based report")
    public void iShouldSeeTheReportGeneratedSuccessfullyForAmountBasedReport() throws IOException {
        String expectedMessage = "Report successfully exported to excel file";
// Wait until the toast notification is visible
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage));
// Get the actual text of the toast message
        String actualMessage = toastMessage.getText();
        System.out.println("✅ Toast Message: " + actualMessage);
// Assert that the actual message contains the expected message
        assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).getText().contains("Report successfully exported to excel file"));
// assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).isDisplayed());


        MediaUtils.takeScreenshotOfTheEntirePage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        myDashboardPage.logoutButton.click();
        actions.sendKeys(Keys.ENTER).perform();
    }

    //TC_03
    @Given("I set the parameters for the report generation based on the user's role")
    public void iSetTheParametersForTheReportGenerationBasedOnTheUserSRole() {
        myReportsPage.selectRole.click();
        myReportsPage.selectRoleManager.click();
        actions.sendKeys(Keys.ENTER).perform();

    }

    @When("I click on the Generate Role Report button")
    public void iClickOnTheGenerateRoleReportButton() throws IOException {
        myReportsPage.reportButton3Users.click();
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Then("I should see the report generated successfully for Role-based report")
    public void iShouldSeeTheReportGeneratedSuccessfullyForRoleBasedReport() throws IOException {
        String expectedMessage = "Report successfully exported to excel file";
// Wait until the toast notification is visible
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage));
// Get the actual text of the toast message
        String actualMessage = toastMessage.getText();
        System.out.println("✅ Toast Message: " + actualMessage);
// Assert that the actual message contains the expected message
        assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).getText().contains("Report successfully exported to excel file"));
// assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).isDisplayed());


        MediaUtils.takeScreenshotOfTheEntirePage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        myDashboardPage.logoutButton.click();
        actions.sendKeys(Keys.ENTER).perform();
    }


    //TC_04
    @Given("I set the parameters for the report generation based on on the start date, end date,and status information")
    public void iSetTheParametersForTheReportGenerationBasedOnOnTheStartDateEndDateAndStatusInformation() throws IOException {
        myReportsPage.startDate2.sendKeys("01/01/2025");
        myReportsPage.endDate2.sendKeys("10/03/2025");
        myReportsPage.selectStatus.click();
        myReportsPage.selectStatusApproved1.click();

        MediaUtils.takeScreenshotOfTheEntirePage();

    }


    @When("I click on the Generate Tour request Report button")
    public void iClickOnTheGenerateTourRequestReportButton() throws IOException {
        myReportsPage.reportButton4TourRequests.click();

        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Then("I should see the report generated successfully for Tour-request-based report")
    public void iShouldSeeTheReportGeneratedSuccessfullyForTourRequestBasedReport() throws IOException {
        String expectedMessage = "Report successfully exported to excel file";
// Wait until the toast notification is visible
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage));
// Get the actual text of the toast message
        String actualMessage = toastMessage.getText();
        System.out.println("✅ Toast Message: " + actualMessage);
// Assert that the actual message contains the expected message
        assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).getText().contains("Report successfully exported to excel file"));
// assertTrue(wait.until(ExpectedConditions.visibilityOf(reportsPage.reportsMessage)).isDisplayed());


        MediaUtils.takeScreenshotOfTheEntirePage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        myDashboardPage.logoutButton.click();
        actions.sendKeys(Keys.ENTER).perform();
    }



}

