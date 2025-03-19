package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.HomePage;
import getlandestate.pages.PropertiesPage;
import getlandestate.utilities.MediaUtils;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class US_11_StepDefs {

    HomePage homePage = new HomePage();
    PropertiesPage properties = new PropertiesPage();

    @Then("customer clicks on sale button")
    public void customer_clicks_on_sale_button() throws IOException {
        homePage.saleButton.click();
        MediaUtils.takeScreenshotOfTheEntirePage();
    }
    @Then("customer clicks on sale property he choose")
    public void customer_clicks_on_sale_property_he_choose() throws IOException {
        properties.saleProperty.click();
        MediaUtils.takeScreenshotOfTheEntirePage();
    }


}
