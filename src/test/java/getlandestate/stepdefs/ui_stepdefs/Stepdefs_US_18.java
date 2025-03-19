package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


import static getlandestate.utilities.ActionsUtils.actions;
import static getlandestate.utilities.WaitUtils.waitFor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Stepdefs_US_18 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ControlPanelPage controlPanelPage = new ControlPanelPage();
    PropertiesPage propertiesPage = new PropertiesPage();
    WebDriverWait wait;
    WebDriver driver;
    MyTourRequestsPage myTourRequestsPage = new MyTourRequestsPage();
    Actions actions = new Actions(Driver.getDriver());
    MyProfilePage myProfilePage = new MyProfilePage();

    public Stepdefs_US_18() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I open {string} with a web browser")
    public void iOpenInAWebBrowser(String url) {
        Driver.getDriver().get(url);
    }

    @When("I select the Login button on the homepage to login")
    public void iSelectTheLoginButtonOnTheHomepageToLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(homePage.loginOption));
        homePage.loginOption.click();
    }

    @And("I give valid manager credentials with username {string} and password {string}")
    public void iGiveValidManagerCredentialsWithUsernameAndPassword(String email, String password) {
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @And("I navigate back to the homepage by clicking the Back to Site tab on the left side of the dashboard")
    public void iNavigateBackToTheHomepageByClickingTheBackToSiteTabOnTheLeftSideOfTheDashboard() throws IOException {
        controlPanelPage.backToSite.click();
        waitFor(3);
        MediaUtils.takeScreenshotOfTheEntirePage();

    }

    //TC_01
    @Given("I click on the properties tab on the homepage to see properties available")
    public void iClickOnThePropertiesTabOnTheHomepageToSeePropertiesAvailable() throws IOException {
        homePage.propertiesButton.click();

        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @And("I choose a property to view")
    public void iChooseAPropertyToView() throws IOException {
        propertiesPage.firstProperty.click();

        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    /*
        @And("I choose a Tour date and time")
        public void iChooseATourDateAndTime() throws IOException {

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

            WebElement tourDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("tourDate")));
            tourDateElement.click();
            tourDateElement.sendKeys("20-03-2025");

            WebElement tourTimeElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("tourTime")));
            Select selectTime = new Select(tourTimeElement);
            selectTime.selectByValue("14:00");

    waitFor(1);

            MediaUtils.takeScreenshotOfTheEntirePage();
        }
    */
    @And("I choose a Tour date and time")
    public void iChooseATourDateAndTime() throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        // Generate a random future date
        String futureDate = getRandomFutureDate(1, 30); // Random between 1 and 30 days ahead

        // Generate a random time between 07:00 and 18:00
        String randomTime = getRandomTime();

        // Select and enter the generated future date
        WebElement tourDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("tourDate")));
        tourDateElement.click();
        tourDateElement.clear();
        tourDateElement.sendKeys(futureDate);

        // Select and enter the generated future time
        WebElement tourTimeElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("tourTime")));
        Select selectTime = new Select(tourTimeElement);
        selectTime.selectByValue(randomTime);

        waitFor(1); // Wait for UI stability

        MediaUtils.takeScreenshotOfTheEntirePage(); // Capture screenshot

        // Log selected date and time for debugging
        System.out.println("✅ Selected Date: " + futureDate);
        System.out.println("✅ Selected Time: " + randomTime);
    }

    // Method to generate a random future date
    public static String getRandomFutureDate(int minDays, int maxDays) {
        Random random = new Random();
        int randomDays = random.nextInt(maxDays - minDays + 1) + minDays; // Random between minDays and maxDays
        LocalDate futureDate = LocalDate.now().plusDays(randomDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return futureDate.format(formatter);
    }

    // Method to generate a random time between 07:00 and 18:00 (hourly intervals)
    public static String getRandomTime() {
        List<String> availableTimes = new ArrayList<>();
        for (int hour = 7; hour <= 18; hour++) {
            availableTimes.add(String.format("%02d:00", hour)); // Format as "HH:00"
        }
        Random random = new Random();
        return availableTimes.get(random.nextInt(availableTimes.size())); // Pick a random time


    }


    @And("I click on the submit a tour request button")
    public void iClickOnTheSubmitATourRequestButton() throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        submitElement.click();

        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Then("I should see a message that the tour request has been submitted successfully")
    public void iShouldSeeAMessageThatTheTourRequestHasBeenSubmittedSuccessfully() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'p-toast-detail') and text()='TourRequest created successfully']")
        ));

        assertTrue(toastMessage.getText().contains("TourRequest created successfully"));
        MediaUtils.takeScreenshotOfTheEntirePage();
//logout from user profile
        homePage.userProfil.click();
        homePage.logoutButton.click();
        actions.sendKeys(Keys.ENTER).perform();
    }


    //TC_02
    @Given("I click on the Profile button at the top-right corner of the website")
    public void i_click_on_the_profile_button_at_the_top_right_corner_of_the_website() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement userProfileElement = wait.until(ExpectedConditions.elementToBeClickable(myProfilePage.myProfile));

        userProfileElement.click();


    }

    @And("I navigate to the My tour requests page")
    public void iNavigateToTheMyTourRequestsPage() {
        myProfilePage = new MyProfilePage(); // Initialize the homePage object

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement myTourRequestsElement = wait.until(ExpectedConditions.elementToBeClickable(myProfilePage.mytourRequests));

        myTourRequestsElement.click();


    }

    @And("I click on MY RESPONSES tab to see the tour requests from other users")
    public void iClickOnMYRESPONSESTabToSeeTheTourRequestsFromOtherUsers() {
        myTourRequestsPage = new MyTourRequestsPage(); // Initialize the myTourRequestsPage object
        myTourRequestsPage.myResponesTab.click();

    }

    @And("I choose to accept or reject a tour request")
    public void iChooseToAcceptOrRejectATourRequest() {
        myTourRequestsPage = new MyTourRequestsPage(); // Initialize the page object

        try {
            // Wait for the parent container (if applicable)
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//td[contains(@data-pc-name, 'datatable')]//span[contains(@data-pc-section, 'value')]\n")
            ));

            // Now wait for the status element itself
            WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//td[@data-pc-name='datatable']//span[@class='p-tag-value']\n")
            ));

            String statusText = statusElement.getText().trim();
            System.out.println("🔎 Current Status: " + statusText);


            if (statusText.equalsIgnoreCase("PENDING")) {
                System.out.println("🚫 Status is PENDING, clicking APPROVE...");
                myTourRequestsPage.acceptButton.click();
                myTourRequestsPage.yesButtonAccept.click();}
            else if (statusText.equalsIgnoreCase("APPROVED")) {
                    System.out.println("🚫 Status is APPROVED, clicking DECLINE...");
                    myTourRequestsPage.rejectButton.click();
                    myTourRequestsPage.yesButtonReject.click(); // Confirm rejection
            } else if (statusText.equalsIgnoreCase("DECLINED")) {
                    System.out.println("✅ Status is DECLINED, clicking APPROVE...");
                    myTourRequestsPage.acceptButton.click();
                    myTourRequestsPage.yesButtonAccept.click(); // Confirm approval
            } else {
                    System.out.println("⚠️ Unknown status: " + statusText);
                }
            } catch(TimeoutException e){
                System.err.println("❌ ERROR: Status element was not found within the time limit.");
            }
        }

        @Then("I should see a message that the tour request has been accepted or rejected successfully")
        public void iShouldSeeAMessageThatTheTourRequestHasBeenAcceptedOrRejectedSuccessfully () throws IOException {

            wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
            assertTrue(wait.until(ExpectedConditions.visibilityOf(myTourRequestsPage.tourRequestApprovalMessage)).isDisplayed());
            System.out.println("Tour request message = " + myTourRequestsPage.tourRequestApprovalMessage2.getText());
           MediaUtils.takeScreenshotOfTheEntirePage();

            //logout from user profile
            homePage.userProfil.click();
            homePage.logoutButton.click();
            actions.sendKeys(Keys.ENTER).perform();

        }

    }


