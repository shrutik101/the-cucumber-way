package aircanada.automation.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/aircanada",
        glue = {"aircanada.automation.stepDefinitions", "aircanada.automation.hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@ui"
//        tags = "@smoketest" // Change this to run specific sets like @loginfeature, @dashboardfeature, etc.
//        Modify the tags attribute to execute different test sets.
//        For example:
//        tags = "@loginfeature" → Runs only login-related tests.
//        tags = "@smoketest" → Runs smoke tests.
//        tags = "@profilefeature or @settingsfeature" → Runs either profile or settings-related tests.
)
public class TestRunner {
}
