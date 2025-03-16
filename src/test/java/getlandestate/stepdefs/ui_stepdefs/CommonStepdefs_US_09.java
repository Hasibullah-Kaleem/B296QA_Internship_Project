package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Given;

public class CommonStepdefs_US_09 {

    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    AdvertsPage advertsPage;
    LanguagesPage languagesPage;


    @Given("admin navigates to {string} homepage")
    public void admin_navigates_to_homepage(String url) {

        Driver.getDriver().get(url);


    }
    @Given("click on Login button")
    public void click_on_login_button() {

        homePage = new HomePage();
        homePage.loginOption.click();

    }
    @Given("enter admin email {string}")
    public void enter_admin_email(String email) {

        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);



    }
    @Given("enter admin password {string}")
    public void enter_admin_password(String password) {

        languagesPage = new LanguagesPage();
        loginPage.passwordInput.sendKeys(password);

    }
    @Given("click on Login option")
    public void click_on_login_option() {

        languagesPage.loginButton2.click();
        WaitUtils.waitFor(1);

    }

}
