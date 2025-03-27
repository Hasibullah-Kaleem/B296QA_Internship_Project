package getlandestate.hooks;

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
import getlandestate.utilities.Driver;

public class Hooks {


//
//    @Before("@pr_iphone or @pr_tesla")
//    public void doSomething(){
//
//
//        // Do something before each scenario
//    }

    public static RequestSpecification spec;

    @Before("@api")
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




    @After
    public void tearDown(Scenario scenario) {

        //We can add some methods to close driver and disconnect from Db.....
        //We can add screenshot methods that provide to attach into the Report.......
        System.out.println("After hooks everything closed.....");

        //if the test cases/scenario fails , then we can capture the Screenshot and attach into the report automatically
        if (scenario.isFailed()) {

            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "failed_screenshot");

            Driver.closeDriver();
        }

//
//        //we can conditional hook using cucumber tags
//
//        @After("@pr_iphone or @pr_tesla")
//        public void afterAllTearDown(){
//
//            System.out.println("this run only after specific tags.......");
//
//        }
//
    }

}