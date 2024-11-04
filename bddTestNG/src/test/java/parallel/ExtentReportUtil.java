package parallel;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports and configure the HTML report
    public static void setupExtentReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Optional: Set additional report configurations
        sparkReporter.config().setReportName("Cucumber Test Report");
        sparkReporter.config().setDocumentTitle("Automation Report");
    }

    // Start a test in the report
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    // Log test steps or results
    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    // Flush and save the report at the end of the test execution
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }

    // Get the ExtentTest instance for logging in step definitions
    public static ExtentTest getTest() {
        return test;
    }
}

