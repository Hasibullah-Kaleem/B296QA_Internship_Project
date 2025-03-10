package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.MyAdvertsPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.MediaUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import static getlandestate.utilities.WaitUtils.waitFor;
//RENTAL

public class StepDefs_US_06 {
    MyAdvertsPage myAdvertsPage = new MyAdvertsPage();
    @Given("I am on the dashboard page of website {string}")
    public void i_am_on_the_dashboard_page_of_website(String url) throws IOException {
        Driver.getDriver().get(url);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I click on the Back To Site button on left corner")
    public void i_click_on_the_back_to_site_button_on_left_corner() throws IOException {
        myAdvertsPage.backToSiteButton.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I click on Create Property button")
    public void i_click_on_create_property_button() throws IOException {
        myAdvertsPage.createPropertyButton.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I upload photo of the property")
    public void i_upload_photo_of_the_property() throws IOException {
        //drag and drop the imagehere.
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @When("I enter a rental title as {string}")
    public void i_enter_a_rental_title_as(String string) throws IOException {
        myAdvertsPage.titleBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter a new description as {string}")
    public void i_enter_a_new_description_as(String string) throws IOException {
        myAdvertsPage.descriptionBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter a new price as {string}")
    public void i_enter_a_new_price_as(String string) throws IOException {
        myAdvertsPage.priceBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} from the Advert Type dropdown as Rent")
    public void i_select_from_the_advert_type_dropdown_as_Rent(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.advertTypeDropdownButton);
        dropdown.selectByIndex(1); //RENT
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} as Luxury from the Category dropdown")
    public void i_select_from_the_category_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.categoryDropdownButton);
        dropdown.selectByIndex(13);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} Turkiye from the Country dropdown")
    public void i_select_from_the_country_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.countryDropdownButton);
        dropdown.selectByIndex(5);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} Izmir from the City dropdown")
    public void i_select_from_the_city_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.cityDropdownButton);
        dropdown.selectByIndex(41);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} Foca from the District dropdown")
    public void i_select_from_the_district_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.districtDropdownButton);
        dropdown.selectByIndex(12);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter the address as this {string}")
    public void i_enter_the_address_as_this(String string) throws IOException {
        myAdvertsPage.addressBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter the room count as a{string}")
    public void i_enter_the_room_count_as_a(String string) throws IOException {
        myAdvertsPage.roomSizeBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} for the pools availability option")
    public void i_select_for_the_pools_availability_option(String string) throws IOException {
        myAdvertsPage.poolAvailabilityBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter the size as a{string}")
    public void i_enter_the_size_as_a(String string) throws IOException {
        myAdvertsPage.bigOrSmallInputBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I click on Create button")
    public void i_click_on_Create_button() throws IOException {
        myAdvertsPage.createButton.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Then("the system should behave appropriately as expected {string}")
    public void the_system_should_behave_appropriately_as_expected(String string) throws IOException {
        //verify the system behavior here.
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
}
