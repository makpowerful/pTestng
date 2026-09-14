package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Setup report directory and filename
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        spark.config().setReportName("Automation Test Execution Report");
        spark.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Java Automation QA");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        try {
            // 1. First, retrieve the driver instance from context
            org.openqa.selenium.WebDriver driver = (org.openqa.selenium.WebDriver) result
                    .getTestContext().getAttribute("WebDriver");
            
            if (driver != null) {
                // FIX: Call the Allure screenshot attachment method here!
                saveScreenshot(driver); 

                // 2. Capture the screenshot as a Base64 string for Extent Report
                String base64Screenshot = ((org.openqa.selenium.TakesScreenshot) driver)
                        .getScreenshotAs(org.openqa.selenium.OutputType.BASE64);
                
                // 3. Attach it to Extent Report
                test.get().fail("Failure Screenshot: ", 
                        com.aventstack.extentreports.MediaEntityBuilder
                        .createScreenCaptureFromBase64String(base64Screenshot).build());
            } else {
                test.get().log(Status.WARNING, "Driver instance not found in TestNG context.");
            }
        } catch (Exception e) {
            test.get().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
        }
    }


    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped / Retrying...");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush(); // Generates the final HTML report file
        }
    }
}
