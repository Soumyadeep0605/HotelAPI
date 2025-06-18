package API_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult; // Import ITestResult

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status; // Import Status for logging
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExcelReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter; // UI of the report
    public ExtentReports extent;             // Common information like doc title, report name
    public ExtentTest test;                  // Entry for the test cases

    String repName; // Name of the report file

    // This method is called before any test class is run.
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Time stamp for unique report name
        repName = "Test-Report-" + timeStamp + ".html"; // Dynamic report name

        // Configure the Spark Reporter for the HTML report
        // Ensure the "reports" directory exists in your project root or create it.
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
        sparkReporter.config().setDocumentTitle("RestAssuredAPIAutomationProjectForHotel"); // Title of the report
        sparkReporter.config().setReportName("Hotel API Testing Data Driven Framework"); // Name of the report
        sparkReporter.config().setTheme(Theme.STANDARD); // Set the theme

        // Initialize ExtentReports and attach the Spark Reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information (optional, but good practice)
        extent.setSystemInfo("Application", "Hotel Booking API");
        extent.setSystemInfo("Module", "Booking Creation");
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
    }

    // This method is called for each test method success.
    public void onTestSuccess(ITestResult result) {
        // Create a new test entry in the report
        test = extent.createTest(result.getName()); // Use the test method name
        test.log(Status.PASS, "Test Passed"); // Log success status
        test.log(Status.PASS, "Test Case: " + result.getName() + " PASSED"); // More detailed message
    }

    // This method is called for each test method failure.
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName()); // Use the test method name
        test.log(Status.FAIL, "Test Failed"); // Log failure status
        test.log(Status.FAIL, "Test Case: " + result.getName() + " FAILED");
        test.log(Status.FAIL, result.getThrowable().getMessage()); // Log the exception/error message
    }

    // This method is called for each test method skipped.
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName()); // Use the test method name
        test.log(Status.SKIP, "Test Skipped"); // Log skipped status
        test.log(Status.SKIP, "Test Case: " + result.getName() + " SKIPPED");
        test.log(Status.SKIP, result.getThrowable().getMessage()); // Log the skip reason (if any)
    }

    // These methods are not typically used for basic reporting, but you can add custom logic.
    public void onTestStart(ITestResult result) {
        // Not implemented for now, as 'createTest' is done in onTestSuccess/Failure/Skipped.
        // If you want to log something before a test starts, you'd put it here.
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not commonly used, refers to tests that fail but are within a defined success percentage.
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result); // Treat timeouts as failures
    }


    // This method is called after all test methods have run.
    public void onFinish(ITestContext testContext) {
        extent.flush(); // Crucial: Writes the report to the specified location
    }
}