package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {

    ReportsPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }
//Reports page first section ADVERTS
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[1]")
    public WebElement reportButton1Adverts;

    @FindBy(xpath = "(//input[@name='startDate'])[1]")
    public WebElement startDate1;

    @FindBy(xpath = "(//input[@name='endDate'])[2]")
    public WebElement endDate1;

    @FindBy(xpath = "(//select[@class='form-select'])[1]")
    public WebElement selectCategory;

    @FindBy(xpath = "(//select[@class='form-select'])[2]")
    public WebElement selectAdvertType;

    @FindBy(xpath = "(//select[@class='form-select'])[3]")
    public WebElement selectStatus;

    @FindBy(xpath = "(//select[@id='status']/option[@value=''])[1]")
    public WebElement selectStatusPending1;

    @FindBy(xpath = "(//select[@id='status']/option[@value='1'])[1]")
    public WebElement selectStatusApproved1;

    @FindBy(xpath = "(//select[@id='status']/option[@value='2'])[1]")
    public WebElement selectStatusRejected1;


//Reports page second section Most popular properties
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[2]")
    public WebElement reportButton2MostPopularProperties;

    @FindBy(xpath = "//input[@id='amount']\n")
    public WebElement amount;




//Reports page third section USERS
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[3]")
    public WebElement reportButton3Users;

    @FindBy(xpath = "(//select[@class='form-select'])[4]")
    public WebElement selectRole;

    @FindBy(xpath = "//select[@id='role']/option[@value='CUSTOMER']\n")
    public WebElement selectRoleCustomer;

    @FindBy(xpath = "//select[@id='role']/option[@value='MANAGER']\n")
    public WebElement selectRoleManager;

    @FindBy(xpath = "//select[@id='role']/option[@value='ADMIN']\n")
    public WebElement selectRoleAdmin;


//Reports page fourth section Tour Requests
    @FindBy(xpath = "(//div[@class='admin-report-button-wrapper'])[4]")
    public WebElement reportButton4TourRequests;

    @FindBy(xpath = "(//input[@name='startDate'])[2]")
    public WebElement startDate2;

    @FindBy(xpath = "(//input[@name='endDate'])[2]")
    public WebElement endDate2;

    @FindBy(xpath = "(//select[@id='status']/option[@value=''])[2]")
    public WebElement selectStatusAll2;

    @FindBy(xpath = "(//select[@id='status']/option[@value=''])[2]")
    public WebElement selectStatusPending2;

    @FindBy(xpath = "(//select[@id='status']/option[@value='1'])[2]")
    public WebElement selectStatusApproved2;

    @FindBy(xpath = "(//select[@id='status']/option[@value='2'])[2]")
    public WebElement selectStatusDeclined2;

    @FindBy(xpath = "(//select[@id='status']/option[@value='3'])[2]")
    public WebElement selectStatusCancelled2;

}
