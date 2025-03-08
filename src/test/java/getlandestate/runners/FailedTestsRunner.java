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
                "rerun:target/failedRerun.txt"
        },

        monochrome = true, //makes the console reports more readable......
        features = "@target/failedRerun.txt",
        glue = "stepdefinitions", // glue is working for stepdefinitions, path of stepdefinitios, add hooks class to attach screenshot....
        dryRun = false //generate the missing stepdefinitios. If you wanna see undefined stepdefs you should make it as true....

)
public class FailedTestsRunner {

}