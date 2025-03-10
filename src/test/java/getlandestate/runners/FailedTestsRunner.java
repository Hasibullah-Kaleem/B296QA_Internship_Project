package getlandestate.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {

                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },

        monochrome = true,
        features = "@target/failedRerun.txt",
        glue = "getlandestate.stepdefs.ui_stepdefs",
        dryRun = false
)
public class FailedTestsRunner {

}