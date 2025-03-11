package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.HomePage;
import getlandestate.pages.PropertiesPage;
import io.cucumber.java.en.Then;

public class US_11_StepDefs {

    HomePage homePage = new HomePage();
    PropertiesPage properties = new PropertiesPage();

    @Then("customer clicks on sale button")
    public void customer_clicks_on_sale_button() {
        homePage.saleButton.click();
    }
    @Then("customer clicks on sale property he choose")
    public void customer_clicks_on_sale_property_he_choose() {
        properties.saleProperty.click();
    }


}
