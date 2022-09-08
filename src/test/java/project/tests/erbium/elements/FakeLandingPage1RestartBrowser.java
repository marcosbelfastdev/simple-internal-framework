package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.flow.BaseTestAccessors;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.FakeLanding.FakeLandingApp;
import project.applications.FakeLanding.pages.AutomationExercisesPage;
import project.applications.FakeLanding.pages.BigPageWithManyElementsPage;
import project.applications.FakeLanding.pages.HomePage;


public class FakeLandingPage1RestartBrowser extends BaseTestAccessors {

    FakeLandingApp browser = new FakeLandingApp(BrowserType.CHROME);

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
        {
            var homePage = new HomePage(browser.driver());
            homePage.automationExercises
                    .setOption(Common.SUPPRESS_DELAYS, true)
                    .click();
            browser.restart();

            var holder = screenHolder(browser.driver());
            browser.goToBaseUrl();
            new HomePage(browser).automationExercises
                    .setOption(Common.SUPPRESS_DELAYS, true)
                    .click();
            var automationExercisesPage = new AutomationExercisesPage(browser);
            automationExercisesPage.bigPageWithManyElementsLink.click();
            var bigPage = new BigPageWithManyElementsPage(browser);
            bigPage.name.scrollDownTo().setText("Some Name");
            new HomePage(browser).facebookLink
                   .scrollDownTo()
                   .setOption(Common.SUPPRESS_DELAYS, false)
                    .setFocus();

            holder.restore();
        }

        System.out.println("Place a breakpooint here");

    }

    @AfterClass
    public void end(ITestContext context) throws Throwable {
        browser.quit();
    }

}
