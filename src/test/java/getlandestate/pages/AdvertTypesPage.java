package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdvertTypesPage {




    public AdvertTypesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "addAdvertType")
    public WebElement addAdvertTypeButton;

    @FindBy(id = "advertTypeName")
    public WebElement advertTypeInput;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;


    @FindBy(xpath = "//table[@id='advertTypeTable']//tr")
    public List<WebElement> advertTypeList;


    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']\n")
    public WebElement loginButton;


    @FindBy(xpath = "//div[@class='form-submit-button']//button[1]")
    public WebElement login;

    @FindBy(xpath = "//div[contains(text(),'Invalid email')]")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//div[contains(text(),'Email is required')]")
    public WebElement requiredEmailMessage;

    @FindBy(xpath = "//div[contains(text(),'Password is required')]")
    public WebElement requiredPasswordMessage;


}