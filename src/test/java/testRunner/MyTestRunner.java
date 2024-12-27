package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"html:target/cucumber-reports/cucumber-html-report.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class MyTestRunner extends AbstractTestNGCucumberTests {
}
