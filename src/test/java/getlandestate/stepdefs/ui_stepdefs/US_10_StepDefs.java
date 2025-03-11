package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class US_10_StepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    PropertiesPage properties = new PropertiesPage();
    PropertyPage propertyPage = new PropertyPage();
    MyProfilePage myProfilePage = new MyProfilePage();
    MyTourRequestsPage myTourRequestsPage = new MyTourRequestsPage();
    Select select;
    WebDriverWait wait;

    @Given("Customer is on the {string} home page")
    public void customer_is_on_the_home_page(String url) {
        Driver.getDriver().get(url);
        WaitUtils.waitFor(5);
    }
    @When("customer clicks on login option")
    public void customer_clicks_on_login_option() {
        homePage.loginOption.click();
    }
    @When("customer enters valid email")
    public void customer_enters_valid_email() {
        loginPage.emailInput.sendKeys("hasibCustomer@gmail.com");
    }
    @When("customer enters valid password")
    public void customer_enters_valid_password() {
        loginPage.passwordInput.sendKeys("Kaleem786hasib%");
    }
    @When("customer clicks of login button")
    public void customer_clicks_of_login_button() {
        loginPage.loginButton.click();
        WaitUtils.waitFor(3);
    }
    @When("customer clicks on rent button")
    public void customer_clicks_on_rent_button() {
        homePage.rentButton.click();
    }
    @When("customer clicks on house category")
    public void customer_clicks_on_house_category() {
        homePage.houseButton.click();
    }

    @When("customer clicks on search icon")
    public void customer_clicks_on_search_icon() {
        homePage.searchButton.click();
        WaitUtils.waitFor(5);
    }
    @Then("customer verifies the result page contains properties")
    public void customer_verifies_the_result_page_contains_properties() {
        assertTrue(properties.property.isDisplayed());

    }
    @Then("customer closes the application")
    public void customer_closes_the_application() {
        Driver.closeDriver();
    }

    //TC_02

    @When("customer enters min price")
    public void customer_enters_min_price() {
        properties.minPrice.sendKeys("1000");
    }
    @When("customer enters max price")
    public void customer_enters_max_price() {
        properties.maxPrice.sendKeys("1250000");
    }
    @When("customer selects advert type")
    public void customer_selects_advert_type() {
        select=new Select(properties.advertType);
        select.selectByVisibleText("Rent");
    }
    @When("customer selects category")
    public void customer_selects_category() {
        select=new Select(properties.category);
        select.selectByVisibleText("House");
    }
    @When("customer selects country")
    public void customer_selects_country() {
        select=new Select(properties.selectCountry);
        select.selectByVisibleText("United Kingdom");
    }
    @When("customer selects city")
    public void customer_selects_city() {
        select=new Select(properties.selectCity);
        select.selectByVisibleText("London");
    }
    @When("customer selects district")
    public void customer_selects_district() {
        select=new Select(properties.selectDist);
        select.selectByVisibleText("All");
        WaitUtils.waitFor(5);
    }
    @When("customer clicks on search")
    public void customer_clicks_on_search() {
        properties.search.click();
        WaitUtils.waitFor(10);
    }

    //TC_03

    @When("customer clicks on property he choose")
    public void customer_clicks_on_property_he_choose() {
        properties.property.click();
        WaitUtils.waitFor(4);
    }
    @Then("customer verifies image, description, details and location information is available")
    public void customer_verifies_image_description_details_and_location_information_is_available() {
        propertyPage.eyeIcon.click();
        assertTrue(propertyPage.contactN.isDisplayed());
        assertTrue(propertyPage.title.isDisplayed());

    }

    //TC_04

    @Then("customer clicks on the eye icon on the right side of contact number")
    public void customer_clicks_on_the_eye_icon_on_the_right_side_of_contact_number() {
        propertyPage.eyeIcon.click();
        WaitUtils.waitFor(3);
    }
    @Then("customer verifies advertiser contact information is visible")
    public void customer_verifies_advertiser_contact_information_is_visible() {
        assertTrue(propertyPage.contactN.isDisplayed());
    }

    //TC_05

    @Then("customer chooses tour date")
    public void customer_chooses_tour_date() {
        propertyPage.tourDate.sendKeys("12/25/2025");
    }
    @Then("customer chooses tour hour")
    public void customer_chooses_tour_hour() {
        propertyPage.tourTime.sendKeys("06:00");
    }
    @Then("customer clicks on submit tour request")
    public void customer_clicks_on_submit_tour_request() {
        propertyPage.submitButton.click();
    }
    @Then("verify customer is able to submit tour request")
    public void verify_customer_is_able_to_submit_tour_request() {
        wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        assertTrue(wait.until(ExpectedConditions.visibilityOf(propertyPage.msg)).isDisplayed());
    }

    //TC_06

    @When("customer clicks on profile")
    public void customer_clicks_on_profile() {
        homePage.userProfile.click();
    }
    @When("customer clicks on my tour requests")
    public void customer_clicks_on_my_tour_requests() {
        myProfilePage.tourRequests.click();
    }
    @Then("verify customer is able to see tour requests")
    public void verify_customer_is_able_to_see_tour_requests() {
        assertTrue(myTourRequestsPage.myTourRequests.isDisplayed());
        System.out.println(myTourRequestsPage.myTourRequests.getText());
        WaitUtils.waitFor(5);
    }

    //TC_07


    @Then("verify customer is able to see the status of tour request")
    public void verify_customer_is_able_to_see_the_status_of_tour_request() {
        wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
        assertTrue(wait.until(ExpectedConditions.visibilityOf(myTourRequestsPage.tourStatus)).isDisplayed());
    }
}
