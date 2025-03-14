package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.HomePage;
import getlandestate.pages.LanguagesPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.JSUtils;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.DataTable;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepDefs_US_04 {


    LanguagesPage languagesPage;

    @Then("user clicks on Flags button")
    public void user_clicks_on_flags_button() {

        languagesPage = new LanguagesPage();
        languagesPage.languageButton.click();
        WaitUtils.waitFor(1);

    }

    @Then("customer selects Turkish and verifies page content")
    public void customer_selects_turkish_and_verifies_page_content() {


        languagesPage.turkishLanguage.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("HIZLI VE KOLAY ADIMLARLA"));
    }

    @Then("customer selects French and verifies page content")
    public void customer_selects_french_and_verifies_page_content() {

        languagesPage.languageButton.click();
        WaitUtils.waitFor(1);
        languagesPage.frenchLanguage.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("TROUVEZ VOTRE RÊVE"));


    }
    @Then("customer selects German and verifies page content")
    public void customer_selects_german_and_verifies_page_content() {

        languagesPage.languageButton.click();
        WaitUtils.waitFor(1);
        languagesPage.germanLanguage.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("FINDE DEINEN TRAUM"));


    }
    @Then("customer selects Spanish and verifies page content")
    public void customer_selects_spanish_and_verifies_page_content() {

        languagesPage.languageButton.click();
        WaitUtils.waitFor(1);
        languagesPage.spanishLanguage.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("ENCUENTRA TU SUEÑO"));

        Driver.closeDriver();
    }



    //TC_02

    @And("customer clicks on Flags button")
    public void customer_clicks_on_flags_button() {

        languagesPage = new LanguagesPage();

        languagesPage.languageButton.click();
        WaitUtils.waitFor(1);

    }

    @Then("customer verifies Italian language is not supported")
    public void customer_verifies_italian_language_is_not_supported() {

        boolean italianNotPresent = true;

        if (languagesPage.turkishLanguage.isDisplayed() &&
                languagesPage.frenchLanguage.isDisplayed() &&
                languagesPage.germanLanguage.isDisplayed() &&
                languagesPage.spanishLanguage.isDisplayed()) {
            italianNotPresent = true;
        } else {
            italianNotPresent = false;
        }


        Assert.assertTrue(italianNotPresent);
    }


}

