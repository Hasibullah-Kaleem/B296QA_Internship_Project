package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[text()='Login']")  //*[@id="offcanvas-menu"]/div[2]/div[2]/div[1]/a[1]
    public WebElement loginOption;


    @FindBy(xpath = "//div[@class='hero']")
    public WebElement userProfile;
    @FindBy(xpath = "//span[text()='My Tour Requests']")
    public WebElement myTourRequests;
    @FindBy(xpath = "//*[@id='root']/div[1]/div//button[1]") public WebElement rentButton;
    @FindBy(xpath = "//*[@id='root']/div[1]//button[2]") public WebElement saleButton;
    @FindBy(xpath = "//div[@class='content-wrapper']//div[3]//button[1]") public WebElement houseButton;
    @FindBy(xpath = "//button[@class='btn btn-primary']") public WebElement searchButton;


    @FindBy(xpath = "//a[@class='nav-link active']")
    public WebElement contactOption;
    @FindBy(className = "user-pic")
    public WebElement userPicture;

}
