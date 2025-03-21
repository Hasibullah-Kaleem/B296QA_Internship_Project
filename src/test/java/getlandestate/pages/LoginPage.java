package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@placeholder='Email']")
    public WebElement emailInput;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(css = "button.submit-button")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[text()='Login']")  // Updated XPath
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='form-submit-button']//button[1]")
    public WebElement login;

    @FindBy(xpath = "//div[contains(text(),'Invalid email')]")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//div[contains(text(),'Email is required')]")
    public WebElement requiredEmailMessage;

    @FindBy(xpath = "//div[contains(text(),'Password is required')]")
    public WebElement requiredPasswordMessage;


    @FindBy (xpath = "//button[@type='submit']\n")
    public WebElement loginOption;

 

}
