package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertiesPage {

    public PropertiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='property-card card'])[1]") public WebElement property;
    @FindBy(xpath = "//input[@id='ps']") public WebElement minPrice;
    @FindBy(xpath = "//input[@id='pe']") public WebElement maxPrice;
    @FindBy(xpath = "//select[@id='at']") public WebElement advertType;
    @FindBy(xpath = "//select[@id='c']") public WebElement category;
    @FindBy(xpath = "//select[@id='ctry']") public WebElement selectCountry;
    @FindBy(xpath = "//select[@id='city']") public WebElement selectCity;
    @FindBy(xpath = "//select[@id='dist']") public WebElement selectDist;
    @FindBy(xpath = "//*[@id='root']/div[1]/div/div[3]/div/div[1]/div/div/form/div/div[8]/div/button") public WebElement search;
    @FindBy(xpath = "(//div[@class='property-card card'])[3]") public WebElement saleProperty;

    @FindBy (xpath = "(//a[@class=' text-decoration-none'])[1]")
    public WebElement firstProperty;


}
