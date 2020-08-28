package ContinuumTraining.CucumberPractice.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src//test//resources//features", glue = "ContinuumTraining.CucumberPractice.stepDefinitions", plugin = {
        "pretty","html:target/Test-Reports/cucumber-html","json:target/Test-Reports/cucumber.json" }, dryRun=true  )
public class TestRunner {

	public TestRunner() {
		// TODO Auto-generated constructor stub
	}

}
