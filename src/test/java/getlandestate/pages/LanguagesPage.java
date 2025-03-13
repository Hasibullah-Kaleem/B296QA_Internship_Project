package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguagesPage {

        public LanguagesPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }


        @FindBy(xpath = "//*[@id='offcanvas-menu']/div[2]/div[2]/div/a/img")
        public WebElement languageButton;

        @FindBy(xpath = "//*[@id='offcanvas-menu']/div[2]/div[2]/div/div/a[2]")
        public WebElement turkishLanguage;

        @FindBy(xpath = "//*[@id='offcanvas-menu']/div[2]/div[2]/div/div/a[3]")
        public WebElement frenchLanguage;

        @FindBy(xpath = "//*[@id='offcanvas-menu']/div[2]/div[2]/div/div/a[4]")
        public WebElement germanLanguage;

        @FindBy(xpath = "//*[@id='offcanvas-menu']/div[2]/div[2]/div/div/a[5]")
        public WebElement spanishLanguage;

        @FindBy(xpath = "//*[@id='root']/div[1]/div/div[2]/div/div/div[1]/div[2]/form/div[4]")
        public WebElement loginButton2;

        @FindBy(xpath = "//span[normalize-space(text())='Back to Site']")
        public WebElement backToSiteButton;

        @FindBy(xpath = "//*[@id='subMenu']/div/a[2]")
        public WebElement myAdvertsMenu;

        @FindBy(xpath = "//*[@id='root']/div[1]/div/div[3]/div/div/div/div[1]/table/tbody/tr/td[5]/div/div/button[2]")
        public WebElement editButton;





    }








