package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.driver.ViewPort;
import framework.core.flow.BaseTestAccessors;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.FakeLandingPage;
import project.pages.FakeLandinPage.AutomationExercisesPage;
import project.pages.FakeLandinPage.BigPageWithManyElementsPage;
import project.pages.FakeLandinPage.HomePage;

import java.util.Arrays;


public class FakeLandingPage3 extends BaseTestAccessors {

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @SuppressWarnings("unchecked")
    public class Parallel extends Thread {
        @Override
        public void run() {
            FakeLandingPage browser = new FakeLandingPage(BrowserType.CHROME);
            try {
                browser.goToBaseUrl();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            var holder = screenHolder(browser.driver());
            try {
                browser.driver().manage().window().setSize(ViewPort.SHD);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            HomePage homePage = null;
            try {
                homePage = new HomePage(browser.driver());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            try {
                homePage.automationExercises
                        .setOption(Common.SUPPRESS_DELAYS, true)
                        .click();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            var automationExercisesPage = new AutomationExercisesPage(browser);
            try {
                automationExercisesPage.bigPageWithManyElementsLink.click();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            var bigPage = new BigPageWithManyElementsPage(browser);
            try {
                bigPage.name.scrollDownTo().setText("Some Name");
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            try {
                homePage.facebookLink
                        .scrollDownTo()
                        .setOption(Common.SUPPRESS_DELAYS, false)
                        .setOption(Common.INTERACT_DELAY_AFTER, 5000)
                        .setFocus();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }

            holder.restore();
            browser.quit();
        }
    }

    @Test
    public void testParallel() {
        Parallel[] parallels = new Parallel[6];
        for (int i=0; i<parallels.length; i++) {
            parallels[i] = new Parallel();
            parallels[i].start();
        }

    }

}
