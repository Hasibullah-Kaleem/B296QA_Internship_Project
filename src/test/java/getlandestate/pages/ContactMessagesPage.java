package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactMessagesPage {
    public ContactMessagesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='admin-contact-message-container']//div[1]//h2[1]//button[1]")
    public WebElement collapsedContactMessage;

    @FindBy(xpath = "//button[@class='accordion-button']")
    public WebElement expandedContactMessage;

    @FindBy(xpath = "//div[@class='accordion-collapse collapse show']//button[@title='Mark as read']//*[name()='svg']")
    public WebElement markAsReadButton;

    @FindBy(xpath = "//button[@title='Delete message']//*[name()='svg']")
    public WebElement deleteButton;

    @FindBy(xpath = "//input[@placeholder='Type Something']")
    public WebElement searchInputBar;

    @FindBy(xpath = "//button[@class='search-button btn btn-primary']//*[@stroke='currentColor']")
    public WebElement searchIcon;

    @FindBy(xpath = "//button[@class='filter-button btn btn-primary']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]")
    public WebElement filterIcon;

    @FindBy(xpath = "//select[@id='status']")
    public WebElement searchInDropdown;

    @FindBy(xpath = "//input[@id='startDate']")
    public WebElement startDatePicker;

    @FindBy(xpath = "//input[@id='endDate']")
    public WebElement endDatePicker;

    @FindBy(xpath = "//button[@title='Apply Filters']//*[name()='svg']")
    public WebElement applyFiltersButton;

}
