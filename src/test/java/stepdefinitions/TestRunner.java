package stepdefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepdefinitions", 
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-reports"}
)

public class TestRunner {
}
