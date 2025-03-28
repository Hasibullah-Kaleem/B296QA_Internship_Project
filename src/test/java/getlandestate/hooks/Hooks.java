package getlandestate.hooks;

import getlandestate.baseurl.BaseUrl;
import getlandestate.utilities.ConfigReader;
import getlandestate.utilities.DBUtils;
import getlandestate.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import getlandestate.utilities.Authentication;
import getlandestate.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before("@db")
    public void connectToDatabase() {
        DBUtils.connectToDatabase();
    }

//
//    @Before("@pr_iphone or @pr_tesla")
//    public void doSomething(){
//
//
//        // Do something before each scenario
//    }

        public static RequestSpecification spec;

    @Before(" @api_us_04_1")
    public void setUpAPI(){

        spec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("apiBaseUrl"))
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", Authentication.generateToken("admin@gmail.com","admin123!"))
                .build();

    }

    @Before
    public void setUp(){

        System.out.println("Before hook executed...");

        //We can add some credetentials to setup our test cases such as Api credentials, db credentials


    }

    @After("@db")
    public void closeDatabaseConnection() {
        getLandEstate.utilities.DB_Utility.closeConnection();
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
