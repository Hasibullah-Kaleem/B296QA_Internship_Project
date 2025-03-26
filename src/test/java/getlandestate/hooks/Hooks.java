package getlandestate.hooks;

import getlandestate.baseurl.BaseUrl;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.DBUtils;
import getlandestate.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before("@db")
    public void connectToDatabase() {
        DBUtils.connectToDatabase();
    }

    @After("@db")
    public void closeDatabaseConnection() {
        DBUtils.closeConnection();
    }

    @Before
    public void setUp() {
        System.out.println("Before hook executed...");
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("After hooks everything closed.....");

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed_screenshot");
        }

        Driver.closeDriver();
    }

    @Before("@ApiAdmin")
    public void apiAdmin() {
        BaseUrl.setUp(ConfigReader.getProperty("adminEmailApi"), ConfigReader.getProperty("adminPasswordApi"));
    }

    @Before("@ApiManager")
    public void apiManager() {
        BaseUrl.setUp(ConfigReader.getProperty("managerEmailApi"), ConfigReader.getProperty("managerPasswordApi"));
    }

    @Before("@ApiUser")
    public void apiUser() {
        BaseUrl.setUp(ConfigReader.getProperty("userEmailApi"), ConfigReader.getProperty("userPasswordApi"));
    }
}
