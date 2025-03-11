package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.PropertyPage;
import getlandestate.utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Stepdefs_US_14 {
    PropertyPage propertyPage;
    @And("User schedules a tour by selecting a Tour Date and Tour Time from the options on the right side of the page")
    public void userSchedulesATourBySelectingATourDateAndTourTimeFromTheOptionsOnTheRightSideOfThePage() {
        propertyPage.tourDate.sendKeys("05/06/2025");
        ReusableMethods.ddmIndex(propertyPage.tourTime,20);
    }

    @And("User confirms the selected date by clicking on the Submit a Tour Request button")
    public void userConfirmsTheSelectedDateByClickingOnTheSubmitATourRequestButton() {
        propertyPage.submitButton.click();
    }

    @Then("User should see the notification Tour request created successfully appear on the page")
    public void userShouldSeeTheNotificationTourRequestCreatedSuccessfullyAppearOnThePage() {
        Assert.assertEquals("TourRequest created successfully", propertyPage.msg.getText());
    }

    @And("User clicks on the Submit a Tour Request button without selecting a Tour Date or Tour Time")
    public void userClicksOnTheSubmitATourRequestButtonWithoutSelectingATourDateOrTourTime() {
        propertyPage.submitButton.click();
    }

    @Then("User should see an error message asking them to select both a Tour Date and Tour Time before submitting the request")
    public void userShouldSeeAnErrorMessageAskingThemToSelectBothATourDateAndTourTimeBeforeSubmittingTheRequest() {
        Assert.assertEquals("Tour date is required", propertyPage.dateRequired.getText());
        Assert.assertEquals("Tour time is required", propertyPage.tourTime.getText());
    }
}
