package framework.core.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverConstrainer {

    WebDriver driver;

    public WebDriverConstrainer(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }

    public void restoreOptions() {

    }

}
