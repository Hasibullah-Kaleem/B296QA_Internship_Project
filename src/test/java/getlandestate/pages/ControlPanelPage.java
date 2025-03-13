package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlPanelPage {
    public ControlPanelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//span[text()='Back to Site']")
    public WebElement backToSite;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[1]/div/div[2]/a[5]/span")
    public WebElement usersMenu;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[1]/div/div[2]/a[2]/span")
    public WebElement advertsMenu;




}
