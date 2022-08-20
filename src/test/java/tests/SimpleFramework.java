package tests;

import framework.applications.PhpTravels;
import framework.core.browsers.single.BaseBrowser;
import framework.core.driver.CoreChromeDriver;
import framework.core.driver.CoreDriver;
import framework.core.driver.CoreFirefoxBrowser;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleFramework {

    BaseBrowser aut;

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @BeforeTest
    public void setup(ITestContext context) {
//        CoreFirefoxBrowser firefox = new CoreFirefoxBrowser();
//        CoreChromeDriver chrome = new CoreChromeDriver();
//        chrome
//                .startIncognito()
//                        .allowPopups()
//                                .disableNotifications()
//                                        .enableAutomation()
//                                                .enableSafeBrowsing()
//                                                        .ignoreCertificateErrors()
//                .build();
//        chrome.open();
//        firefox.open();

        PhpTravels phpTravels = new PhpTravels(BrowserType.CHROME);
        


    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() {
        System.out.println("Test is running...");
    }

}
