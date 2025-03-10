package getlandestate.pages;

import getlandestate.utilities.Driver;
import getlandestate.utilities.WaitUtils;
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
    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;
}
