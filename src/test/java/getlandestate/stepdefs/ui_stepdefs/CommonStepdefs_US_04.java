package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.ControlPanelPage;
import getlandestate.pages.HomePage;
import getlandestate.pages.LanguagesPage;
import getlandestate.pages.LoginPage;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepdefs_US_04 {

    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    LanguagesPage languagesPage;



    @Given("user is on the {string} homepage")
    public void user_is_on_the_homepage(String url) {

        Driver.getDriver().get(url);


    }
    @Given("user clicks on login button")
    public void user_clicks_on_login_button() {

        homePage = new HomePage();
        homePage.loginOption.click();

    }
    @Given("user enters valid customer email {string} into email field")
    public void user_enters_valid_customer_email_into_email_field(String email) {

        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);



    }
    @Given("user enters valid password {string} into password field")
    public void user_enters_valid_password_into_password_field(String password) {

        languagesPage = new LanguagesPage();
        loginPage.passwordInput.sendKeys(password);
    }

        @Given("user clicks on second login button")
        public void user_clicks_on_second_login_button() {

            languagesPage.loginButton2.click();
            WaitUtils.waitFor(1);



    }
    @And("user clicks on back to site button")
    public void user_clicks_on_back_to_site_button() {

//        languagesPage = new LanguagesPage();
//        languagesPage.backToSiteButton.click();
//        WaitUtils.waitFor(1);



    }



}
