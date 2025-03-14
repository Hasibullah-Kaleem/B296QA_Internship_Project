package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {

    public UsersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Type Something']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div/div[1]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div/div[2]/div/div/div[1]/table/tbody/tr[2]/td[5]/div/div/button[2]")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id='role']")
    public WebElement roleDropdown;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div[1]/form/div[2]/button[3]")
    public WebElement updateButton;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[text()='User type save successfully']")
    public WebElement successMessage;

    @FindBy(xpath = "/html/body/div[2]/div[2]/button[2]/span")
    public WebElement yesOption;

    @FindBy(xpath = "//div[text()='User deleted successfully']")
    public WebElement deleteMessage;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement userEmail;






}
