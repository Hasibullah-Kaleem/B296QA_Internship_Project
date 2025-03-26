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
        features = "src/test/resources/features/api_features",
        glue = {"getlandestate.stepdefs.api_stepdefs", "getlandestate.hooks"},
        dryRun = false,

        tags = "@ApiManager and @api_us_08"


)
public class Runner {
}



