package framework.core.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class CoreDriver {

    protected WebDriver driver;
    protected String browserType;

    public CoreDriver(String browserType) {
        this.browserType = browserType;
    }

    protected void setDriver(WebDriver driver) {
        this.driver = driver;
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
        if (driver != null) {
            for(String window : driver.getWindowHandles()) {
                try {
                    driver.switchTo().window(window);
                    driver.close();
                } catch (Exception ignored) {

                }
            }
            try {
                driver.quit();
            } catch (Exception ignored) {

            }
            driver = null;
        }
    }
}
