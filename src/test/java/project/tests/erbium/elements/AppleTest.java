package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.driver.ViewPort;
import framework.core.flow.BaseTestAccessors;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.Apple.AppleApp;
import project.applications.Apple.pages.HomePage;


public class AppleTest extends BaseTestAccessors {

    AppleApp browser = new AppleApp(BrowserType.CHROME);

    @BeforeTest
    public void setup(ITestContext context) throws Throwable {
        browser.goToBaseUrl();
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @SuppressWarnings("unchecked")
    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() throws Throwable {

        var holder = screenHolder(browser.driver());
        browser.driver().manage().window().setSize(ViewPort.SHD);
        var homePage = new HomePage(browser);
        homePage.contactApple
                .setOption(Common.SUPPRESS_DELAYS, true)
                .scrollDownTo()
                .setFocus()
                .click();

        holder.restore();
    }

    @AfterClass
    public void end(ITestContext context) throws Throwable {
        browser.quit();
    }

}
