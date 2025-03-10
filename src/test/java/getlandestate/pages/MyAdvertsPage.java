package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAdvertsPage {

    public MyAdvertsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space()='Back to Site']")
    public WebElement backToSiteButton;
    @FindBy(xpath = "//span[@class='d-none d-lg-block']")
    public WebElement createPropertyButton;
    @FindBy(xpath = "//input[@id='title']")
    public WebElement titleBox;
    @FindBy(xpath = "//textarea[@id='desc']")
    public WebElement descriptionBox;
    @FindBy(xpath = "//input[@id='price']")
    public WebElement priceBox;
    @FindBy(xpath = "//select[@id='advertTypeId']")
    public WebElement advertTypeDropdownButton;
    @FindBy(xpath = "//select[@id='categoryId']")
    public WebElement categoryDropdownButton;
    @FindBy(xpath = "//select[@id='countryId']")
    public WebElement countryDropdownButton;
    @FindBy(xpath = "//select[@id='cityId']")
    public WebElement cityDropdownButton;
    @FindBy(xpath = "//select[@id='districtId']")
    public WebElement districtDropdownButton;
    @FindBy(xpath = "//input[@id='address']")
    public WebElement addressBox;
    @FindBy(xpath = "//input[@id='room']")
    public WebElement roomSizeBox;
    @FindBy(xpath = "//input[@id='pool']")
    public WebElement poolAvailabilityBox;
    @FindBy(xpath = "//input[@id='big or small']")
    public WebElement bigOrSmallInputBox;
    @FindBy(xpath = "//div[@class='upload-area']")
    public WebElement uploadImageArea;
    @FindBy(xpath = "//button[normalize-space()='Create']")
    public WebElement createButton;
    @FindBy(xpath = "")
    public WebElement successMessageAlert;
}
