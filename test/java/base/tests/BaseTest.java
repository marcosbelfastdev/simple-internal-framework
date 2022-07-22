package base.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.utils.TestProps;
import core.utils.TestReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BaseTest extends TestReporter {

    protected static ExtentHtmlReporter reporter;
    protected static ExtentReports reports;
    protected static ExtentTest test;

    public static void logStep(String message) {
        Reporter.log("=> " + message);
        System.out.println("=> " + message);
        test.log(Status.PASS, message);
    }

    public static void screenshot(WebDriver driver, String message) {
        String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        String screenshotLog = "<div><p>=> Screenshot: " + message + "</p>" +
                "<img src=\"data:image/png;base64, " + screenshot + "\" alt=\"Screenshot\"" +
                "width=100%; height=100%; object-fit: contain; />" +
                "</div>";
        Reporter.log(screenshotLog);
        System.out.println("=> Screenshot: " + message);
        test.log(Status.PASS, screenshotLog);
    }

    public static ExtentReports getExtentReports() {
        return reports;
    }

    @BeforeClass
    public void setup(ITestContext context) {

        LocalDateTime now = LocalDateTime.now();
        String slash = System.getProperty("file.separator");
        String path = System.getProperty("user.home") + slash + "output" +
                slash + now.getMonth() + "-" + now.getDayOfMonth() + "-" + now.getDayOfWeek() + "_" + now.getHour() +
                "." + now.getMinute() + "." + now.getSecond();

        reporter = new ExtentHtmlReporter(path + slash + context.getCurrentXmlTest().getClass().getSimpleName());
        reports = new ExtentReports();
        reports.attachReporter(reporter);

    }

    @AfterMethod
    public void cleanup(ITestResult result) {

        if (!result.isSuccess()) {
            test.log(Status.FAIL, "Test failed");
            return;
        }

        test.log(Status.PASS, "Test passed");

    }

    @AfterTest
    public void afterTest() {
        reporter.flush();
    }


}
