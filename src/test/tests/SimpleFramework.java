package tests;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.core.browsers.multiple.BaseWebApplicationMultipleBrowsers;

public class SimpleFramework {

    BaseWebApplicationMultipleBrowsers aut;

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @BeforeTest
    public void setup(ITestContext context) {
        aut = new BaseWebApplicationMultipleBrowsers(context);
        aut.startAllBrowsers();
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() {
        System.out.println("Test is running...");
        aut.restartCurrentBrowser();
    }

}
