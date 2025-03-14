package getlandestate.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvertsPage {

    @FindBy(xpath = "//*[@id=\"tourDate\"]")
    public WebElement tourDate;

    @FindBy(xpath = "//*[@id='tourDate']")
    public WebElement tourTime;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/div[2]/div[2]/div/div[2]/div/form/div[5]/button")
    public WebElement submitButton2;

@FindBy(xpath = "//div[contains(@class, 'p-toast-detail') and text()='TourRequest created successfully']")
    public WebElement TourRequestMessage;  // Created TourRequest created successfully



}
