package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTourRequestsPage {
    public MyTourRequestsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//p[text()='MY RESPONSES']")
    public WebElement myResponesTab;
    @FindBy (xpath = "(//button[@type='button'])[13]")
    public WebElement actionYesTick;
    @FindBy(xpath = "(//li[@class='nav-item'])[1]") public WebElement myTourRequests;
    @FindBy(xpath = "(//span[@class='p-tag p-component'])[1]") public WebElement tourStatus;

    @FindBy(xpath = "//button[contains(@class, 'approve-button')]\n") public WebElement acceptButton;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-accept')]\n") public WebElement yesButtonAccept;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-reject')]\n") public WebElement noButtonAccept;

    @FindBy(xpath = "//button[contains(@class, 'decline-button')]\n") public WebElement rejectButton;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-accept')]\n") public WebElement yesButtonReject;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-reject')]\n") public WebElement noButtonReject;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div") public WebElement tourRequestApprovalMessage;
}
