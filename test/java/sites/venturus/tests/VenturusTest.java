package sites.venturus.tests;

import base.tests.BaseTest;
import core.driver.DriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import sites.venturus.funcs.LogoutFunc;

public class VenturusTest extends BaseTest {

    /*
    Classes willing to extend this will have to use 1 single browser in principle
     */

    protected DriverManager driverManager;
    private WebDriver browser;

    public WebDriver getBrowser() {
        return browser;
    }

    public void init(String browserType) {
        driverManager = new DriverManager();
        browser = driverManager.launchBrowser(browserType);
        browser.manage().window().setSize(new Dimension(1920,1080)); // provided that the UAT won't scroll in any way...
    }

    @AfterMethod
    public void methodTearDown() {
        new LogoutFunc(getBrowser()).logout();
        driverManager.quit();
    }

    @AfterClass
    public void classTearDown() {
        driverManager.quit();
    }

}
