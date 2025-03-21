package getlandestate.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {

                "pretty", //generates reports in the console....
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },

        monochrome = true,
       // features = "src/test/resources/features/ui_features",
        features = "src/test/resources/features",

       // glue = {"getlandestate.stepdefs.ui_stepdefs", "getlandestate.hooks"},
        glue = {
                "getlandestate.stepdefs.api",
                "getlandestate.stepdefs.db",
                "getlandestate.stepdefs.ui_stepdefs",
                "getlandestate.stepdefs.db_stepdefs"
        },
        dryRun = false,


        tags =  "@db_us_13"




)
public class Runner {
}



