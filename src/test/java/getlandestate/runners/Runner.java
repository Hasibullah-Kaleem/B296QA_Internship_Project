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
        features = "src/test/resources/features/ui_features",
        glue = {"getlandestate.stepdefs.ui_stepdefs", "getlandestate.hooks"},
        dryRun = false,
<<<<<<< HEAD
        tags = "@us_18"
=======
<<<<<<< HEAD
        tags = "@us_02"
=======
        tags = "@us_17"
>>>>>>> origin/Boukadida
>>>>>>> 9d414e69f372712a246e73526d18b45e6ee35fb2

)
public class Runner {
}



