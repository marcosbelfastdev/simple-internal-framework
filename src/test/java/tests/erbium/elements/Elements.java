package tests.erbium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Elements {

    GoogleApplication google = new GoogleApplication(BrowserType.CHROME);

    public class HomePage {
        Driver _driver;
        public HomePage(Driver driver) {
            this._driver = driver;
        }
        public void search(String text) {
            var searchBox = new Element(By.name("q"));
            searchBox.setOption(Common.HIGHLIGHT_ELEMENTS, true)
        }
    }

    @BeforeTest
    public void setup(ITestContext context) {
        google.goToBaseUrl();
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() {

    }





}
