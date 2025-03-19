package getlandestate.pages;

import getlandestate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {

    public CategoriesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[normalize-space()='Categories']")
    public WebElement categoriesMenu;

    @FindBy(id = "addCategoryButton")
    public WebElement addCategoryButton;

    @FindBy(id = "categoryNameInput")
    public WebElement categoryNameInput;

    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createCategoryButton;

    @FindBy(xpath = "//div[@class='success-message']")
    public WebElement categorySuccessMessage;

    // **Buraya successMessage ekliyoruz**
    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    public WebElement editCategoryButton;

    @FindBy(xpath = "//input[@id='sequenceNumber']")
    public WebElement sequenceNumberInput;

    @FindBy(xpath = "//button[contains(text(),'Update')]")
    public WebElement updateButton;
}


