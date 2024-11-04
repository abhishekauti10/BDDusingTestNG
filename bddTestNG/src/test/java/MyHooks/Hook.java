package MyHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Hook {

	private static ExtentReports extent;
	private static ExtentTest scenarioTest;
	private static WebDriver driver;

	@Before
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");           // Run in headless mode
		options.addArguments("--disable-gpu");        // Disable GPU acceleration (optional)
		options.addArguments("--window-size=1920,1080"); // Set window size for headless

		driver = new ChromeDriver(options);
	}

	@Before//(order = 0)  // This hook runs at the beginning of the test run
	public void setupExtentReport() {
		if (extent == null) {
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			// Optional: Set report properties
			sparkReporter.config().setReportName("Cucumber Test Execution Report");
			sparkReporter.config().setDocumentTitle("Automation Test Results");
		}
	}

	@Before//(order = 1)
	public void startScenario(Scenario scenario) {
		// Start a new ExtentTest instance for the scenario
		scenarioTest = extent.createTest(scenario.getName());
		scenarioTest.info("Starting scenario: " + scenario.getName());
	}

	@After
	public void tearDownScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			scenarioTest.fail("Scenario failed: " + scenario.getName());
		} else {
			scenarioTest.pass("Scenario passed: " + scenario.getName());
		}
		scenarioTest.info("Ending scenario: " + scenario.getName());
	}

	@After//(order = 1)
	public void flushExtentReport() {
		if (extent != null) {
			extent.flush();
		}
	}

	// Use this getter to access the current test instance from step definitions
	public static ExtentTest getScenarioTest() {
		return scenarioTest;
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
