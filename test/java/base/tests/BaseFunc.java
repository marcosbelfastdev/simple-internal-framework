package java.base.tests;

import core.utils.TestReporter;
import org.openqa.selenium.WebDriver;

public class BaseFunc {

    public static void logStep(String message) {
        base.tests.BaseTest.logStep(message);
    }

    public static void screenshot(WebDriver driver, String message) {
        base.tests.BaseTest.screenshot(driver, message);
    }
}
