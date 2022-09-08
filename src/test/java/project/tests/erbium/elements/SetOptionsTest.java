package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.flow.BaseTestAccessors;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.FakeLanding.FakeLandingApp;
import project.applications.FakeLanding.pages.HomePage;


public class SetOptionsTest extends BaseTestAccessors {

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
    public void setOptions() throws Throwable {

        /**
         * Print all playback options for comparison
         */
        System.out.println("CURRENT DRIVER OPTIONS");
        System.out.println(browser.driver().getOptionsMap());

        var element = new HomePage(browser).automationExercises;

        /**
         * Print all current element options
         * which should be the same as the driver options at this time
         */
        System.out.println("CURRENT ELEMENT OPTIONS");
        System.out.println(browser.driver().getOptionsMap());

        // assert they are the same
        Assert.assertEquals(browser.driver().getOptionsMap().toString(), element.getOptionsMap().toString());

        // # SITUATION 1
        // sets a different option for element
        // the diff should be exactly that new setting
        element.setOption(Common.HIGHLIGHT_ELEMENTS, false);
        Assert.assertEquals(element.getDiffOptionsMap().size(), 1);
        Assert.assertEquals(element.getDiffOptionsMap().get(Common.HIGHLIGHT_ELEMENTS), false);

        // # SITUATION 2
        // after element options are reset, there should be no difference
        element.resetOptions();
        Assert.assertEquals(element.getDiffOptionsMap().size(), 0);
        Assert.assertEquals(element.getDiffOptionsMap().containsKey(Common.HIGHLIGHT_ELEMENTS), false);
        Assert.assertEquals(browser.driver().getOptionsMap().toString(), element.getOptionsMap().toString());

        // # SITUATION 3
        // now we will set the same driver option on element
        // and expect that options are the same, however, the diff map is not
        element.setOption(Common.HIGHLIGHT_ELEMENTS, browser.driver().getOption(Common.HIGHLIGHT_ELEMENTS));
        Assert.assertEquals(element.getDiffOptionsMap().size(), 1);
        Assert.assertEquals(element.getDiffOptionsMap().containsKey(Common.HIGHLIGHT_ELEMENTS), true);
        Assert.assertEquals(browser.driver().getOptionsMap().toString(), element.getOptionsMap().toString());

        // # SITUATION 4
        // now diff option exists and all options are the same
        // let us change driver option
        // diff should still exists, options are different between driver and element
        browser.driver().setOption(Common.HIGHLIGHT_ELEMENTS, false);
        Assert.assertEquals(element.getDiffOptionsMap().size(), 1);
        Assert.assertEquals(element.getDiffOptionsMap().containsKey(Common.HIGHLIGHT_ELEMENTS), true);
        Assert.assertNotEquals(browser.driver().getOptionsMap().toString(), element.getOptionsMap().toString());

        // # SITUATION 5
        // now following a browser reset, situation is back to # SITUATION 3
        element.setOption(Common.HIGHLIGHT_ELEMENTS, browser.driver().getOption(Common.HIGHLIGHT_ELEMENTS));
        Assert.assertEquals(element.getDiffOptionsMap().size(), 1);
        Assert.assertEquals(element.getDiffOptionsMap().containsKey(Common.HIGHLIGHT_ELEMENTS), true);
        Assert.assertEquals(browser.driver().getOptionsMap().toString(), element.getOptionsMap().toString());

        // # SITUATION 6
        // after element reset, situation will be # SITUATION 2
        element.resetOptions();
        Assert.assertEquals(element.getDiffOptionsMap().size(), 0);
        Assert.assertEquals(element.getDiffOptionsMap().containsKey(Common.HIGHLIGHT_ELEMENTS), false);
        Assert.assertEquals(browser.driver().getOptionsMap().toString(), element.getOptionsMap().toString());

    }

    @AfterClass
    public void end(ITestContext context) throws Throwable {
        browser.quit();
    }

}
