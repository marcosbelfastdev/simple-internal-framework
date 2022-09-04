package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.flow.BaseTestAccessors;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.FakeLandingPage;


public class Elements extends BaseTestAccessors {

    FakeLandingPage fakeLandingPageApp = new FakeLandingPage(BrowserType.CHROME);

    public class HomePage {
        Driver _driver;
        public HomePage(Driver driver) {
            this._driver = driver;
        }
        public Element search(String text) throws Throwable {
            var searchBox = new Element(_driver, By.name("q"));
            searchBox.setElementName("searchBox");
            searchBox
                    .setOption(Common.HIGHLIGHT_ELEMENTS, true);
            searchBox.clear().setText("Unhighlight search term");
            searchBox.clear().setText("Highlight search term");
            searchBox.clear().setText("New Text");
            return searchBox;
        };
    }

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
            fakeLandingPageApp.driver().manage().window().setSize(new Dimension(500, 500));
            new HomePage(fakeLandingPageApp.driver()).search("test");
            holder.restore();
        }


        System.out.println("Check");
    }





}
