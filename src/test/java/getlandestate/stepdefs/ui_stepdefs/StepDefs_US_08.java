package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.MyAdvertsPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.MediaUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static getlandestate.utilities.WaitUtils.waitFor;

public class StepDefs_US_08 {
    MyAdvertsPage myAdvertsPage = new MyAdvertsPage();
    @Given("I am on the main page {string}")
    public void i_am_on_the_main_page(String url) throws IOException {
        Driver.getDriver().get(url);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Given("I click on the Profile icon on the top right corner")
    public void i_click_on_the_profile_icon_on_the_top_right_corner() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I click on the My Adverts option from the profile dropdown")
    public void i_click_on_the_my_adverts_option_from_the_profile_dropdown() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I am landed on the My Adverts page {string}")
    public void i_am_landed_on_the_my_adverts_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I randomly select the 2nd advertisement's Edit\\(pen) option")
    public void i_randomly_select_the_2nd_advertisement_s_edit_pen_option() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("I am on the Edit Advert page for the 2nd ad {string}")
    public void i_am_on_the_edit_advert_page_for_the_2nd_ad(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I change the price of the advertisement to {string}")
    public void i_change_the_price_of_the_advertisement_to(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the Update button to save changes")
    public void i_click_on_the_update_button_to_save_changes() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I confirm the update action in the confirmation popup")
    public void i_confirm_the_update_action_in_the_confirmation_popup() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I am redirected to the My Adverts page {string}")
    public void i_am_redirected_to_the_my_adverts_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see the Date Published title")
    public void i_see_the_date_published_title() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see the Status title")
    public void i_see_the_status_title() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see the View-Like-Tour title")
    public void i_see_the_view_like_tour_title() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the Delete button for the 2nd ad")
    public void i_click_on_the_delete_button_for_the_2nd_ad() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on Yes to confirm the deletion")
    public void i_click_on_yes_to_confirm_the_deletion() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I confirm the delete action in the confirmation popup")
    public void i_confirm_the_delete_action_in_the_confirmation_popup() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the advertisement should be successfully deleted")
    public void the_advertisement_should_be_successfully_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
