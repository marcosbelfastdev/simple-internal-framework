package project.tests.erbium.elements;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.driver.ViewPort;
import framework.core.flow.BaseTestAccessors;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import project.applications.FakeLanding.FakeLandingApp;
import project.applications.FakeLanding.pages.AutomationExercisesPage;
import project.applications.FakeLanding.pages.BigPageWithManyElementsPage;
import project.applications.FakeLanding.pages.HomePage;


public class NewTest extends BaseTestAccessors {

    WebDriver driver;

    @BeforeTest
    public void setup(ITestContext context) throws Throwable {
        WebDriverManager.chromedriver().arm64().setup();
        driver = new ChromeDriver();
        //driver = WebDriverManager.chromedriver().getWebDriver();
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @SuppressWarnings("unchecked")
    @Test(description = "Demo Test - Test color selection in Treeview")
    public void firstTest() throws Throwable {
        {
           driver.navigate().to("http://apple.com");
        }

        System.out.println("Place a breakpooint here");
    }

    @AfterClass
    public void end(ITestContext context) throws Throwable {
        //browser.quit();
    }

}
