package getlandestate.stepdefs.ui_stepdefs;

import getlandestate.pages.*;
import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStepdefs_US_05 {

    HomePage homePage;
    LoginPage loginPage;
    ControlPanelPage controlPanelPage;
    UsersPage usersPage;
    LanguagesPage languagesPage;


    @Given("admin is on the {string} homepage")
    public void admin_is_on_the_homepage(String url) {

        Driver.getDriver().get(url);

    }
    @Given("admin clicks on login button")
    public void admin_clicks_on_login_button() {

        homePage = new HomePage();
        homePage.loginOption.click();

    }
    @Given("admikn enters valid admin email {string} into email field")
    public void admikn_enters_valid_admin_email_into_email_field(String email) {

        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);



    }
    @Given("admin enters valid password {string} into password field")
    public void admin_enters_valid_password_into_password_field(String password) {

        languagesPage = new LanguagesPage();
        loginPage.passwordInput.sendKeys(password);



    }
    @Given("admin clicks on second login button")
    public void admin_clicks_on_second_login_button() {

        languagesPage.loginButton2.click();
        WaitUtils.waitFor(1);

    }
    @Then("admin clicks on Users tab")
    public void admin_clicks_on_users_tab() {

        controlPanelPage = new ControlPanelPage();
        controlPanelPage.usersMenu.click();
        WaitUtils.waitFor(1);

    }
    @Then("types {string} into search input box and click search button")
    public void types_into_search_input_box_and_click_search_button(String userName) {

        usersPage = new UsersPage();
       usersPage.searchBox.sendKeys(userName);
        WaitUtils.waitFor(1);
        usersPage.searchButton.click();
        WaitUtils.waitFor(1);



    }










}
