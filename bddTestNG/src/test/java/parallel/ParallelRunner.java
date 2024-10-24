package parallel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.DriverFactory.DriverFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = {"/Users/abhishekauti/eclipse-workspace/bddTestNG/src/test/resources/parallel"}		// Path for feature files or give package name
		,glue= {"parallel"}			// Path for step definition, hooks files or package name
		//,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",		//extend report
				"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "html:target/cucumber-reports/cucumberWebTestreports.html",
                "rerun:target/failedRun.txt"		// This shows the additional components in console,
                }			
		,dryRun = false										//True = no actual execution will take place, false = Actual execution will happen
		,tags = ("@RegressionTest or @SmokeTest")
		)	


public class ParallelRunner extends AbstractTestNGCucumberTests  {
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	
//	@Parameters({"browser"})
//    @BeforeClass
//    public void setUp(String browser) {
//        // Initialize WebDriver based on browser parameter
//        DriverFactory.setBrowser(browser);
//    }
	
	

}

