package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "@target/failedRun.txt",  // Rerun the failed scenarios
		glue = "parallel",                  
		plugin = {
				"pretty",
				"html:target/cucumber-reports-rerun.html"  // Rerun report
		}
		)


public class FailedTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}