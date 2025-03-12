package getlandestate.stepdefs.ui_stepdefs;

import com.github.javafaker.Faker;
import getlandestate.pages.PropertyPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.ReusableMethods;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Stepdefs_US_14 {
    PropertyPage propertyPage;
    Faker faker;
    @And("User schedules a tour by selecting a Tour Date and Tour Time from the options on the right side of the page")
    public void userSchedulesATourBySelectingATourDateAndTourTimeFromTheOptionsOnTheRightSideOfThePage() {
        propertyPage = new PropertyPage();
        faker = new Faker();
        Date futureDate = faker.date().future(365, TimeUnit.DAYS);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(futureDate);
        propertyPage.tourDate.sendKeys(formattedDate);
        ReusableMethods.ddmIndex(propertyPage.tourTime,20);
        WaitUtils.waitFor(5);
    }

    @And("User confirms the selected date by clicking on the Submit a Tour Request button")
    public void userConfirmsTheSelectedDateByClickingOnTheSubmitATourRequestButton() {
        propertyPage.submitButton.click();
        WaitUtils.waitFor(2);
    }

    @Then("User should see the notification Tour request created successfully appear on the page")
    public void userShouldSeeTheNotificationTourRequestCreatedSuccessfullyAppearOnThePage() {
        Assert.assertEquals("TourRequest created successfully", propertyPage.successMsg.getText());
        Driver.closeDriver();
    }

    @And("User clicks on the Submit a Tour Request button without selecting a Tour Date or Tour Time")
    public void userClicksOnTheSubmitATourRequestButtonWithoutSelectingATourDateOrTourTime() {
        propertyPage = new PropertyPage();
        propertyPage.submitButton.click();
        WaitUtils.waitFor(2);
    }

    @Then("User should see an error message asking them to select both a Tour Date and Tour Time before submitting the request")
    public void userShouldSeeAnErrorMessageAskingThemToSelectBothATourDateAndTourTimeBeforeSubmittingTheRequest() {
        Assert.assertEquals("Tour date is required", propertyPage.dateRequired.getText());
        Assert.assertEquals("Tour time is required", propertyPage.timeRequired.getText());
        WaitUtils.waitFor(2);
        Driver.closeDriver();
    }
}
