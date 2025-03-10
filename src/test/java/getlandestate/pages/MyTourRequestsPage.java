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
    @FindBy (xpath = "//button[contains(@class, 'approve-button')]")
    public WebElement actionYesTick;
    @FindBy (xpath = "//button[contains(@class, 'decline-button')]")
    public WebElement actionNoTick;
    @FindBy (xpath = "//button[@aria-label='Yes']")
    public WebElement sureYesTick;
    @FindBy (xpath = "//button[@aria-label='No']")
    public WebElement sureNoTick;
    @FindBy (xpath = "//button[@aria-label='No']")
    public WebElement requestAcceptedNotification;
    @FindBy (xpath = "//span[text()='APPROVED']")
    public WebElement approvedStatus;
    @FindBy (xpath = "//span[text()='DECLINED']")
    public WebElement declinedStatus;
}
