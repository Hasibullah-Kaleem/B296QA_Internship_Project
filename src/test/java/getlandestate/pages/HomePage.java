package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginOption;
    @FindBy(xpath = "//div[@class='hero']")
    public WebElement userProfile;
    @FindBy(xpath = "//span[text()='My Tour Requests']")
    public WebElement myTourRequests;

    @FindBy(xpath = "//a[@class='nav-link active']")
    public WebElement contactOption;

}
