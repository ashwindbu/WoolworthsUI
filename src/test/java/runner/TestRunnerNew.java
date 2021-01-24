package runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="features",
        glue="stepDefinition",
        plugin={"json:target/cucumber-reports/cucumber.json",
                "pretty", "html:target/html-report/cucumber-html-reports.html",
                "junit:target/cucumber-reports/cucumber.xml"},monochrome = true
)
public class TestRunnerNew {

}

