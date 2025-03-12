package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.RegisterPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.MediaUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static getlandestate.utilities.WaitUtils.waitFor;

public class StepDefs_US_01 {

    RegisterPage registerPage = new RegisterPage();

    @Given("the user is on the homepage of the website {string}")
    public void the_user_is_on_the_homepage_of_the_website(String url) throws IOException {
        Driver.getDriver().get(url);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }

    @Given("the user clicks on the {string} button on the top right corner")
    public void the_user_clicks_on_the_button_on_the_top_right_corner(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters {string} in the first name input box")
    public void the_user_enters_in_the_first_name_input_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters {string} in the last name input box")
    public void the_user_enters_in_the_last_name_input_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters {string} in the phone number input box")
    public void the_user_enters_in_the_phone_number_input_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters {string} in the email address input box")
    public void the_user_enters_in_the_email_address_input_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters {string} in the password input box")
    public void the_user_enters_in_the_password_input_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user reenters {string} in the confirm password input box")
    public void the_user_reenters_in_the_confirm_password_input_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks on the checkbox to agree with Terms of Use")
    public void the_user_clicks_on_the_checkbox_to_agree_with_terms_of_use() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("{string} is displayed")
    public void is_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
