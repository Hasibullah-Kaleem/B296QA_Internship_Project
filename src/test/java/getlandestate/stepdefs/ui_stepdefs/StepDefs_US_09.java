package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.ActionsUtils;
import getlandestate.utilities.Driver;
import getlandestate.utilities.JSUtils;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class StepDefs_US_09 {

    ControlPanelPage controlPanelPage;
    AdvertsPage advertsPage;
    LanguagesPage languagesPage;
    HomePage homePage;

    @When("admin clicks on Adverts menu")
    public void admin_clicks_on_adverts_menu() {

        controlPanelPage = new ControlPanelPage();
        controlPanelPage.advertsMenu.click();
        WaitUtils.waitFor(1);

    }
    @When("type {string} into search box")
    public void type_into_search_box(String text) {

        advertsPage = new AdvertsPage();
        advertsPage.searchBox.sendKeys(text);
        WaitUtils.waitFor(1);



    }
    @When("type {string} into min price box")
    public void type_into_min_price_box(String minPrice) {

       // advertsPage.priceStart.click();
        advertsPage.priceStart.sendKeys(minPrice);
        WaitUtils.waitFor(1);

    }
    @When("type {string} into max price box")
    public void type_into_max_price_box(String maxPrice) {

 advertsPage.priceEnd.sendKeys(maxPrice);



    }
    @Then("click on Advert type dropdown and select Sale")
    public void click_on_advert_type_dropdown_and_select_sale() {

        Select dropdown = new Select(advertsPage.advertTypeDropdown);
        dropdown.selectByVisibleText("Sale");
        WaitUtils.waitFor(1);

    }
    @Then("click on Status dropdown menu and select Pending")
    public void click_on_status_dropdown_menu_and_select_pending() {

        advertsPage = new AdvertsPage();
        Select dropdown = new Select(advertsPage.statusDropdown);
        dropdown.selectByVisibleText("Pending");
        WaitUtils.waitFor(1);

    }
    @Then("click on Category dropdown menu and select {string}")
    public void click_on_category_dropdown_menu_and_select(String string) {

        Select dropdown = new Select(advertsPage.categoryDropdown);
        dropdown.selectByVisibleText("House");
        WaitUtils.waitFor(1);

    }
    @Then("click on Search button")
    public void click_on_search_button() {

       advertsPage.searchButton.click();
       WaitUtils.waitFor(1);


    }
    @Then("click on chosen advert's Edit button")
    public void click_on_chosen_advert_s_edit_button() {

        advertsPage.editButton.click();
        WaitUtils.waitFor(1);

    }
    @Then("click on Status dropdown menu and activate the advert")
    public void click_on_status_dropdown_menu_and_activate_the_advert() {

        JSUtils.JSscrollIntoView(advertsPage.statusForAdvertDropdown);
        Select dropdown = new Select(advertsPage.statusForAdvertDropdown);
        dropdown.selectByIndex(1);
        WaitUtils.waitFor(1);

        JSUtils.JSscrollIntoView(advertsPage.updateButton);
        advertsPage.updateButton.click();


    }

    @Then("Verify success message is displayed:{string}")
    public void verify_success_message_is_displayed(String successMessage) {

        Assert.assertTrue(advertsPage.successMessage.isDisplayed());
        Driver.closeDriver();

    }

    //TC_02


    @When("admin clicks on back to site button")
    public void admin_clicks_on_back_to_site_button() {

        languagesPage = new LanguagesPage();

        languagesPage.backToSiteButton.click();
        WaitUtils.waitFor(1);



    }
    @When("admin clicks on Account button")
    public void admin_clicks_on_account_button() {

        homePage = new HomePage();
        homePage.userProfile.click();


    }
    @When("admin clicks on My Adverts button")
    public void admin_clicks_on_my_adverts_button() {

        languagesPage = new LanguagesPage();
        languagesPage.myAdvertsMenu.click();

    }
    @When("admin cicks on Edit button")
    public void admin_cicks_on_edit_button() {

        languagesPage = new LanguagesPage();
        languagesPage.editButton.click();
        WaitUtils.waitFor(1);

    }
    @When("enter invalid\\/negative data {string} into Price input box")
    public void enter_invalid_negative_data_into_price_input_box(String invalidData) {

        advertsPage = new AdvertsPage();

        advertsPage.price.click();
        for (int i = 0; i < invalidData.length(); i++) {
            advertsPage.price.sendKeys(Keys.BACK_SPACE);
        }

        WaitUtils.waitFor(1);

        advertsPage.price.sendKeys(invalidData);
        WaitUtils.waitFor(1);



    }
    @Then("verify Update button is disabled\\/ not clickable")
    public void verify_update_button_is_disabled_not_clickable() {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(advertsPage.uploadButton).perform();

        boolean isButtonDisabled = false;

        try {

            advertsPage.updateButton.click();
            isButtonDisabled = false;
        } catch (Exception e) {

            isButtonDisabled = true;
        }



    }


}
