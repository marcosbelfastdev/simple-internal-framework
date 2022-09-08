package project.tests;

import com.github.marcosbelfastdev.erbium.core.Common;
import project.applications.FakeLanding.FakeLandingApp;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {

    FakeLandingApp flp = new FakeLandingApp(BrowserType.CHROME);

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
    public void firstTest() throws Throwable {
        flp.goToBaseUrl();
        flp.driver().setOption(Common.SCREEN_SIZE, new Dimension(700,800));
        flp.driver().reset();
        System.out.println("Finished.");
    }





}
