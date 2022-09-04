package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
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
            new HomePage(fakeLandingPageApp.driver()).automationExercises
                    .setOption(Common.INTERACT_DELAY_AFTER, 3000)
                    .setOption(Common.SUPPRESS_DELAYS, true)
                    .click();
            new AutomationExercisesPage(fakeLandingPageApp.driver())
                    .bigPageWithManyElementsLink()
                            .click();

            holder.restore();
        }


        System.out.println("Check");
    }





}
