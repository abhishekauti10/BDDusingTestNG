package parallel;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		features = {"/Users/abhishekauti/git/BDDusingTestNG/bddTestNG/src/test/resources/parallel/login.feature"}		// Path for feature files or give package name
		,glue= {"parallel"}			// Path for step definition, hooks files or package name
		//,stepNotifications = true			// Shows test cases in result heirarchy
		,plugin = {//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",		//extend report
				"pretty",
                "html:target/cucumber-reports/cucumberWebTestreports.html",
                "rerun:target/failedRun.txt"		// This shows the additional components in console,
                }			
		,dryRun = false										//True = no actual execution will take place, false = Actual execution will happen
		,tags = ("@RegressionTest or @SmokeTest")
		)	


public class ParallelRunner extends AbstractTestNGCucumberTests  {
	
//	@BeforeTest
//	@Parameters({"browser"})
//	public void defineBrowser(String browser) {
//		ConfigReader.setBrowserType(browser);
//		System.out.println(browser);
//		
//	}
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
	

}

