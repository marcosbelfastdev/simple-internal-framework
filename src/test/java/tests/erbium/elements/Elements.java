package tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.applications.GoogleApplication;


public class Elements {

    GoogleApplication google = new GoogleApplication(BrowserType.CHROME);

    public class HomePage {
        Driver _driver;
        public HomePage(Driver driver) {
            this._driver = driver;
        }
        public void search(String text) throws Throwable {
            var searchBox = new Element(_driver, By.name("q"));
            searchBox.setElementName("searchBox");
            searchBox
                    .setOption(Common.HIGHLIGHT_ELEMENTS, false)
                            .setOption(Common.INTERACT_DELAY_AFTER, 2000);
            searchBox.clear().setText("Unhighlight search term");
            searchBox.setOption(Common.HIGHLIGHT_ELEMENTS, true);
            searchBox.clear().setText("Highlight search term");
            searchBox.resetOptions();
            _driver.setOption(Common.INTERACT_DELAY_AFTER, 5000);
            //searchBox.setOption(Common.INTERACT_DELAY_AFTER, 1000);
            //_driver.setOption(Common.PAGE_LOAD_TIMEOUT, 0);
            searchBox.clear().setText("New Text");
        }
    }

    @BeforeTest
    public void setup(ITestContext context) throws Throwable {
        google.goToBaseUrl();
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() throws Throwable {
        new HomePage(google.driver())
                .search("Search term");
    }





}
