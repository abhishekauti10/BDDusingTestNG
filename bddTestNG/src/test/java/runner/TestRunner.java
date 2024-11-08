package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = {"/Users/abhishekauti/git/BDDusingTestNG/bddTestNG/src/test/resources/feature/login.feature"}		// Path for feature files or give package name
		,glue= {"pageObject"}			// Path for step definition, hooks files or package name
		//,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",		//extend report
				"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumberWebTestreports.html",
                "rerun:target/failedRunner.txt"		// This shows the additional components in console,
                }			
		,dryRun = false										//True = no actual execution will take place, false = Actual execution will happen
		//,tags = ("@RegressionTest or @SmokeTest")
		)	


public class TestRunner extends AbstractTestNGCucumberTests  {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
	

}

