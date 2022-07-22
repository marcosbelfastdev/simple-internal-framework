package java.internalFramework.listeners.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;
    private String browserType;

    public DriverManager(String browserType) {
        launchBrowser(browserType);
    }

    private void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public String getBrowserType() {
        return browserType;
    }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public synchronized WebDriver launchBrowser(String browserType) {

        WebDriver driver = null;
        switch (browserType) {
            case BrowserType.CHROME:
                driver = launchChrome();
                break;
            case BrowserType.SAFARI:
                driver = launchSafari();
                break;
            case BrowserType.FIREFOX:
                driver = launchFirefox();
                break;
        }

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
        setDriver(driver);
        setBrowserType(browserType);
        return driver;
    }

    private WebDriver launchChrome() {
        WebDriver webDriver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--ignore-certificate-errors");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private WebDriver launchSafari() {
        WebDriver webDriver;
        webDriver = new SafariDriver();
        return webDriver;
    }

    private WebDriver launchFirefox() {
        WebDriver webDriver;
        WebDriverManager.firefoxdriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        /*
        Quite like this thing about creating new profiles not to mix up with
        user's current profile
         */
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("security.tls.version.max", 3);
        profile.setPreference("security.tls.version.enable-deprecated", true);
        firefoxOptions.setProfile(profile);
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        /*
        Seems like too many options, huh?
        We do not need them so these preferences could be ditched,
        however, I learned these are useful for downloads in Firefox
        (when you create a download method or something to work with these).
        Additional settings could include a specific download folder for all browsers.
        This folder could be unique per test run.
         */
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxOptions.addPreference("browser.download.panel.shown", false);
        firefoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/plain, application/octet-stream, application/binary, text/csv, application/csv, application/excel, text/comma-separated-values, text/xml, application/xml");
        firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
        firefoxOptions.addPreference("browser.download.useDownloadDir", true);
        firefoxOptions.addPreference("browser.download.panel.shown", true);
        firefoxOptions.addPreference("browser.download.improvements_to_download_panel", true);
        firefoxOptions.merge(capabilities);
        webDriver = new FirefoxDriver(firefoxOptions);
        return webDriver;
    }

    public WebDriver driver() {
        return driver;
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
