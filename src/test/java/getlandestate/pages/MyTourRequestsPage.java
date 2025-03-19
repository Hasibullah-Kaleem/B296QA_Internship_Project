package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTourRequestsPage {
    public MyTourRequestsPage()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//p[text()='MY RESPONSES']")
    public WebElement myResponesTab;
    @FindBy (xpath = "//button[contains(@class, 'approve-button')]")
    public WebElement actionYesTick;

    @FindBy (xpath = "//button[@class='btn-link decline-button btn btn-primary']")
    public WebElement actionNoTick;
    @FindBy (xpath = "//button[@aria-label='Yes']")
    public WebElement sureYesTick;
    @FindBy (xpath = "//button[@aria-label='No']")
    public WebElement requestAcceptedNotification;
    @FindBy (xpath = "//span[text()='APPROVED']")
    public WebElement approvedStatus;
    @FindBy (xpath = "//span[text()='DECLINED']")
    public WebElement declinedStatus;

    @FindBy(xpath = "(//li[@class='nav-item'])[1]")
    public WebElement myTourRequests;
    @FindBy(xpath = "(//span[@class='p-tag p-component'])[1]")
    public WebElement tourStatus;

    @FindBy(xpath = "//button[contains(@class, 'approve-button')]\n") public WebElement acceptButton;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-accept')]\n") public WebElement yesButtonAccept;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-reject')]\n") public WebElement noButtonAccept;

    @FindBy(xpath = "//button[contains(@class, 'decline-button')]\n") public WebElement rejectButton;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-accept')]\n") public WebElement yesButtonReject;
    @FindBy(xpath = "//button[contains(@class, 'p-confirm-popup-reject')]\n") public WebElement noButtonReject;

    @FindBy(xpath = "//div[@class='p-toast-detail' and contains(text(), 'Tour request')]\n") public WebElement tourRequestApprovalMessage;
    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div") public WebElement tourRequestApprovalMessage2;
    @FindBy(xpath = "//*[@id=\"react-aria8798142331-:r3:-tabpane-response\"]/div/div/div/div[1]/table/tbody/tr[1]/td[6]/div/span[2]/button[2]")
    public WebElement acceptButton2;


    @FindBy(xpath = "//button[contains(@class, 'expand-button')]")
    public WebElement expandDetails;

    @FindBy(xpath = "//button[contains(@class, 'edit-owner-guest')]")
    public WebElement editOwnerGuest;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//button[text()='Update']")
    public WebElement updateButton;

    @FindBy(xpath = "//div[contains(@class, 'error-message')]")
    public WebElement errorMessage;
}


