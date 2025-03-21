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
        features = "src/test/resources/features/db_features",
        glue = {"getlandestate.stepdefs.db_stepdefs", "getlandestate.hooks"},
        dryRun = false,

        tags = "@db and @db_us_09"


)
public class Runner {
}



