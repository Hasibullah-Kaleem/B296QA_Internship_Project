package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyPage {

    public PropertyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='advert-details-owner-phone']//button[2]") public WebElement eyeIcon;
    @FindBy(xpath = "//div[@class='advert-details-owner-phone']//button[1]") public WebElement contactN;
    @FindBy(id = "tourDate") public WebElement tourDate;
    @FindBy(id = "tourTime") public WebElement tourTime;
    @FindBy(xpath = "//div[@class='tour-request-form-button-wrapper']/button") public WebElement submitButton;
    @FindBy(xpath = "//*[@id='root']/div[2]/div") public WebElement msg;
    @FindBy(xpath = "//h4[@class='description-title']") public WebElement description;
    @FindBy(xpath = "//h4[@class='advert-properties-title']") public WebElement title;
    @FindBy(xpath = "//h4[@class='advert-location-title']") public WebElement location;
    @FindBy(xpath = "//div[@class='modal-content']//p[2]") public WebElement warningMsg;
    @FindBy(xpath = "//span[@class='register-link']") public WebElement createNow;
    @FindBy(xpath = "//div[text()='TourRequest created successfully']") public WebElement successMsg;
    @FindBy(xpath = "//div[text()='Tour date is required']") public WebElement dateRequired;
    @FindBy(xpath = "//div[text()='Tour time is required']") public WebElement timeRequired;



}
