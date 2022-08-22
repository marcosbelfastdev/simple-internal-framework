package tests;

import framework.applications.FakeLandingPage;
import framework.applications.Worker;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SimpleTest {

    FakeLandingPage flp = new FakeLandingPage(BrowserType.CHROME);
    FakeLandingPage flp2 = new FakeLandingPage(BrowserType.CHROME);
    FakeLandingPage flp3 = new FakeLandingPage(BrowserType.CHROME);
    FakeLandingPage flp4 = new FakeLandingPage(BrowserType.CHROME);
    FakeLandingPage flp5 = new FakeLandingPage(BrowserType.CHROME);

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @BeforeTest
    public void setup(ITestContext context) {



    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() {
        flp.goToBaseUrl();
        flp2.goToBaseUrl();
        flp3.goToBaseUrl();
        flp4.goToBaseUrl();
        flp5.goToBaseUrl();
    }





}
