package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertsPage {

    public AdvertsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='q']")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id='price_start']")
    public WebElement priceStart;

    @FindBy(xpath = "//*[@id='price_end']")
    public WebElement priceEnd;

    @FindBy(xpath = "//*[@id='status']")
    public WebElement selectDropdown;

    @FindBy(xpath = "//*[@id='advert_type_id']")
    public WebElement advertTypeDropdown;

    @FindBy(xpath = "//*[@id='category_id']")
    public WebElement categoryDropdown;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div[1]/form/div/div[7]/div/button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div[3]/div/div/div/div[1]/table/tbody/tr[1]/td[5]/div/div/button[2]")
    public WebElement editButton;


    @FindBy(xpath = "//*[@id='status']")
    public WebElement statusDropdown;

    @FindBy(xpath = "//*[@id='root']/div[1]/div[2]/div[2]/div/form/div[6]/button[2]")
    public WebElement updateButton;

    @FindBy(xpath = "//div[text()='Advert updated successfully']")
    public WebElement successMessage;

    @FindBy(xpath = "//*[@id='statusForAdvert']")
    public WebElement statusForAdvertDropdown;

    @FindBy(xpath = "//*[@id='price']")
    public WebElement price;

    @FindBy(xpath = "//*[@id='root']/div[1]/div/div[1]/form/div[2]/button")
    public WebElement uploadButton;
}
