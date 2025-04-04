package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    public ContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement contactFirstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement contactLastNameInput;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement contactEmailInput;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement contactMessageInput;

    @FindBy(xpath = "//button[normalize-space()='SEND']")
    public WebElement contactSendButton;

    @FindBy(xpath = "//div[@class='p-toast-message-text']")// or //div[@class='p-toast-detail']
    public WebElement contactSuccessMessage;

    @FindBy(xpath = "//div[normalize-space()='At least 2 characters']")
    public WebElement contactNameWarningMessage;

    @FindBy(xpath = "//div[normalize-space()='Invalid email']")
    public WebElement contactEmailWarningMessage;
}
