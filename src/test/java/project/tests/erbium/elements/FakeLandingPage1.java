package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import com.github.marcosbelfastdev.erbium.core.Timer;
import framework.core.driver.ViewPort;
import framework.core.flow.BaseTestAccessors;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.FakeLandingPage;
import project.pages.FakeLandinPage.AutomationExercisesPage;
import project.pages.FakeLandinPage.BigPageWithManyElementsPage;
import project.pages.FakeLandinPage.HomePage;


public class FakeLandingPage1 extends BaseTestAccessors {

    FakeLandingPage fakeLandingPageApp = new FakeLandingPage(BrowserType.CHROME);

    @BeforeTest
    public void setup(ITestContext context) throws Throwable {
        fakeLandingPageApp.goToBaseUrl();
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @SuppressWarnings("unchecked")
    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() throws Throwable {
        {
            var holder = screenHolder(fakeLandingPageApp.driver());
            fakeLandingPageApp.driver().manage().window().setSize(ViewPort.FHD);
            fakeLandingPageApp.driver().getWrappedWebDriver().manage().window().maximize();
            new HomePage(fakeLandingPageApp.driver()).automationExercises
                    .setOption(Common.SUPPRESS_DELAYS, true)
                    .click();
            new AutomationExercisesPage(fakeLandingPageApp)
                    .bigPageWithManyElementsLink
                            .click();
            new BigPageWithManyElementsPage(fakeLandingPageApp.driver())
//                    .name
//                        .scrollDownTo()
//                        .setOption(Common.INTERACT_DELAY_AFTER, 3000)
//                        .setFocus()
//                        .setText("Marcos Ghiraldelli");
        .facebookLink.scrollDownTo().setFocus();
            Timer.sleep(10000);

            holder.restore();
        }


        System.out.println("Check");
    }

}
