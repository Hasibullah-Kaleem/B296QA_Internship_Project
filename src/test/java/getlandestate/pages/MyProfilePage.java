package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {

    public MyProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id=\"root\"]/div[1]/nav/div/div[2]/div/div/img") public WebElement myProfile;

    @FindBy(partialLinkText = "My Tour Requests") public WebElement tourRequests;
    @FindBy(xpath = "//*[@id=\"subMenu\"]/div/a[4]/span[1]") public WebElement mytourRequests;
}
