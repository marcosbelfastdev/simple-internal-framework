package project.tests;

import core.Drivers;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class AppiumTest {

    Drivers drivers = Drivers.getInstance();

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @Test(priority = 0)
    public void setup(ITestContext context) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setAppActivity("splash.SplashActivity")
                .setAppPackage("com.kayak.android");
                //.setAdbPort(5554);
                //.setRemoteAdbHost("100.112.170.21");

        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://localhost:4723"), options
        );

        drivers.setAppiumDriver(driver);
    }

    @Test(priority = 1)
    public void doSomeStuff() {
        AppiumDriver driver = drivers.getAppiumDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement skip1 = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.kayak.android:id/skipButton\")"));
        skip1.click();
        WebElement skip2 = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.kayak.android:id/skipButton\")"));
        skip2.click();
    }
}
