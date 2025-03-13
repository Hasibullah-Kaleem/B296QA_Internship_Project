package getlandestate.utilities;


import getlandestate.pages.*;
import getlandestate.utilities.Driver;

public class BaseStepDefinitions {

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ControlPanelPage controlPanelPage;

    public void openWebPage(String url) {
        Driver.getDriver().get(url);
    }

    public void clickLoginButton() {
        homePage = new HomePage();
        homePage.loginOption.click();
    }

    public void enterManagerCredentials(String email, String password) {
        loginPage = new LoginPage();
        loginPage.emailInput.sendKeys(email);
        loginPage.passwordInput.sendKeys(password);
    }

    public void clickReportsButton() {
        ReportsPage reportsPage = new ReportsPage();
        reportsPage.reportSectionButton.click();
    }

    public void navigateBackToHomepage() {
        controlPanelPage = new ControlPanelPage();
        controlPanelPage.backToSite.click();
    }
}
