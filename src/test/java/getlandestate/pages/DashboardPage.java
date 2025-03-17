package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='ContactMessages']")
    public WebElement contactMessagesSection;

    @FindBy(xpath = "//a[@title='Reports']")
    public WebElement reportSectionButton;

    @FindBy(xpath = "//a[@title='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='error-message']")
    public WebElement errorMessage;


}



