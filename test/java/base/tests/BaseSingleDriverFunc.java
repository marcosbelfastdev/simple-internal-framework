package base.tests;

import base.tests.BaseFunc;
import org.openqa.selenium.WebDriver;

public class BaseSingleDriverFunc extends BaseFunc {

    WebDriver driver;

    public BaseSingleDriverFunc(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getBrowser() {
        return driver;
    }
}
