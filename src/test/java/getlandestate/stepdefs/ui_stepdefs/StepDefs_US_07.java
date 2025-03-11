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
//SALE
public class StepDefs_US_07 {
    MyAdvertsPage myAdvertsPage = new MyAdvertsPage();
    @Given("I am on the dashboard page of the website {string}")
    public void i_am_on_the_dashboard_page_of_the_website(String url) throws IOException {
        Driver.getDriver().get(url);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I click on the Back To Site button")
    public void i_click_on_the_back_to_site_button() throws IOException {
        myAdvertsPage.backToSiteButton.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I click on the Create Property button")
    public void i_click_on_the_create_property_button() throws IOException {
        myAdvertsPage.createPropertyButton.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I upload a photo of the property")
    public void i_upload_a_photo_of_the_property() throws IOException {
        //drag and drop the imagehere.
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @When("I enter a title as {string}")
    public void i_enter_a_title_as(String string) throws IOException {
        myAdvertsPage.titleBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter a description as {string}")
    public void i_enter_a_description_as(String string) throws IOException {
        myAdvertsPage.descriptionBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter a price as {string}")
    public void i_enter_a_price_as(String string) throws IOException {
        myAdvertsPage.priceBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} from the Advert Type dropdown as Sale")
    public void i_select_from_the_advert_type_dropdown_as_Sale(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.advertTypeDropdownButton);
        dropdown.selectByIndex(2); //SALE
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} from the Category dropdown")
    public void i_select_from_the_category_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.categoryDropdownButton);
        dropdown.selectByIndex(13);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} from the Country dropdown")
    public void i_select_from_the_country_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.countryDropdownButton);
        dropdown.selectByIndex(5);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} from the City dropdown")
    public void i_select_from_the_city_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.cityDropdownButton);
        dropdown.selectByIndex(41);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} from the District dropdown")
    public void i_select_from_the_district_dropdown(String string) throws IOException {
        Select dropdown = new Select(myAdvertsPage.districtDropdownButton);
        dropdown.selectByIndex(12);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter the address as {string}")
    public void i_enter_the_address_as(String string) throws IOException {
        myAdvertsPage.addressBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter the room count as {string}")
    public void i_enter_the_room_count_as(String string) throws IOException {
        myAdvertsPage.roomSizeBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I select {string} for the pool availability option")
    public void i_select_for_the_pool_availability_option(String string) throws IOException {
        myAdvertsPage.poolAvailabilityBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I enter the size as {string}")
    public void i_enter_the_size_as(String string) throws IOException {
        myAdvertsPage.bigOrSmallInputBox.sendKeys(string);
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @And("I click on the Create button")
    public void i_click_on_the_Create_button() throws IOException {
        myAdvertsPage.createButton.click();
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Then("the system should behave appropriately as {string}")
    public void the_system_should_behave_appropriately_as(String string) throws IOException {
        //verify the system behavior here.
        waitFor(1);
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
}
