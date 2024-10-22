package project.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {


    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @Test
    public void setup(ITestContext context) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAppActivity("com.kayak.android/.navigation.MainActivity")
                .setAppPackage("com.kayak.android")
                .setAdbPort(5554);
                //.setRemoteAdbHost("100.112.170.21");

        AndroidDriver driver = new AndroidDriver(
                // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                new URL("http://100.112.170.21:4723"), options
        );

        System.out.println(((AppiumDriver) driver).getCapabilities());


    }
}
