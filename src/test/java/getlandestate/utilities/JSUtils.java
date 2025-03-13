package getlandestate.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {

    /**
     * Scrolls to the specified element.
     * @param element The WebElement to scroll to.
     */
    public static void JSscrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls all the way down the page.
     */
    public static void JSscrollAllTheWayDown() {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Scrolls all the way up the page.
     */
    public static void JSscrollAllTheWayUp() {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }

    /**
     * Clicks on the specified element, waits for the element to be visible, and scrolls to it.
     * @param element The WebElement to click.
     */
    public static void JSclickWithTimeout(WebElement element) {
        ((JavascriptExecutor) getlandestate.utilities.Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(element, 5));
        ((JavascriptExecutor) getlandestate.utilities.Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Locates the element with the specified ID and returns it.
     * @param idOfElement The ID of the element to locate.
     * @return The located WebElement.
     */
    public WebElement JSlocateElements(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();
        return ((WebElement) js.executeScript("return document.getElementById('" + idOfElement + "')"));
    }

    /**
     * Writes the specified text to the given element.
     * @param inputElement The WebElement to write text to.
     * @param text The text to write.
     */
    public static void JSsetValueBy(WebElement inputElement, String text) {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + text + "')", inputElement);
    }

    /**
     * Returns the value of the element with the specified ID.
     * @param idOfElement The ID of the element to get the value from.
     * @return The value of the element.
     */
    public static String JSgetValueBy(String idOfElement) {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();
        String value = js.executeScript("return document.getElementById('" + idOfElement + "').value").toString();
        System.out.println(value);
        return value;
    }

    /**
     * Handles JavaScript alerts.
     * @return The text of the alert.
     */
    public static String JSgetAlertTextAndAccept() {
        JavascriptExecutor js = (JavascriptExecutor) getlandestate.utilities.Driver.getDriver();

        try {
            // Switch to alert
            org.openqa.selenium.Alert alert = getlandestate.utilities.Driver.getDriver().switchTo().alert();

            // Get alert text
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);

            // Accept (close) the alert
            alert.accept();

            return alertText;
        } catch (Exception e) {
            System.out.println("No alert found.");
            return null;
        }
    }

}