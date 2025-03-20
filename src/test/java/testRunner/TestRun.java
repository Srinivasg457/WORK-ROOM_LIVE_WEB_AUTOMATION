package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/home/limitscale/Documents/CurrentProject/Live_ChataakProjectWebautomation/src/test/java/Features",
        glue = "stepDefinations",
        dryRun = false,
        tags ="@sanity or @regression", // Ensure correct tag syntax,
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html", // HTML Report
                "json:target/cucumber-reports/cucumber.json", // JSON Report
                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Extent Reports
        },
        monochrome = true

)
public class TestRun {
}
