package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.PropertiesPage;
import getlandestate.pages.PropertyPage;
import getlandestate.pages.RegisterPage;
import getlandestate.utilities.ActionsUtils;
import getlandestate.utilities.Driver;
import getlandestate.utilities.MediaUtils;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class US_12_StepDefs {

    PropertyPage propertyPage = new PropertyPage();
    RegisterPage registerPage = new RegisterPage();
    WebDriverWait wait;

    @Then("verify customer is able to see details of the property")
    public void verify_customer_is_able_to_see_details_of_the_property() throws IOException {
        assertTrue(propertyPage.description.isDisplayed());
        assertTrue(propertyPage.title.isDisplayed());
        assertTrue(propertyPage.location.isDisplayed());

        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Then("verify customer is not able to see advertiser contact information and warning message appear")
    public void verify_customer_is_not_able_to_see_advertiser_contact_information_and_warning_message_appear() throws IOException {
        assertTrue(propertyPage.warningMsg.isDisplayed());
        System.out.println(propertyPage.warningMsg.getText());
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Then("verify customer is not able to submit tour request")
    public void verify_customer_is_not_able_to_submit_tour_request() throws IOException {
        assertTrue(propertyPage.warningMsg.isDisplayed());
        System.out.println(propertyPage.warningMsg.getText());
        WaitUtils.waitFor(5);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Then("customer clicks on create now")
    public void customer_clicks_on_create_now() throws IOException {
        assertTrue(propertyPage.warningMsg.isDisplayed());
        wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(propertyPage.createNow)).click();
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Then("verify customer is directed to registration page")
    public void verify_customer_is_directed_to_registration_page() throws IOException {
        Actions actions = new Actions(Driver.getDriver());
        ActionsUtils.scrollDown();
        assertTrue(registerPage.registrationButton.isDisplayed());
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
}
