package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features/GoogleSearch.feature",
        glue="stepDefinitions",
        plugin= {"pretty","html:test-output"}
)
public class GoogleSearchRunner {

}
