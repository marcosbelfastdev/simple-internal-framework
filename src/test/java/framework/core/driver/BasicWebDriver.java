package framework.core.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BasicWebDriver implements IBasicWebDriver {

    protected WebDriver _webDriver;
    protected String _browserType;


    protected void setWebDriver(WebDriver _webDriver) {
        this._webDriver = _webDriver;
    }

    protected void setBrowserType(String _browserType) {
        _browserType = _browserType;
    }

    protected String getBrowserType() {
        return _browserType;
    }


    public WebDriver driver() {
        return _webDriver;
    }

    protected void setJavaHook(WebDriver driver) {
        class Quit extends Thread {
            private final WebDriver driver;
            public Quit(WebDriver driver) {
                this.driver = driver;
            }
            @Override
            public void run() {
                try {
                    driver.quit();
                } catch (Exception ignore) {

                }
            }
        }

        /*
        This will TRY to get the webdriver executable finished in task manager or
        some process manager out there and quit the browser
        when/even if you do not terminate the test politely.
         */
        Runtime.getRuntime().addShutdownHook(new Quit(driver));
        Objects.requireNonNull(driver).manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public synchronized void quit() {
        if (_webDriver != null) {
            for(String window : _webDriver.getWindowHandles()) {
                try {
                    _webDriver.switchTo().window(window);
                    _webDriver.close();
                } catch (Exception ignored) {

                }
            }
            try {
                _webDriver.quit();
            } catch (Exception ignored) {

            }
            _webDriver = null;
        }
    }
}
