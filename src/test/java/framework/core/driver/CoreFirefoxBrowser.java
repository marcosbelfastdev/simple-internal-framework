package framework.core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CoreFirefoxBrowser extends CoreDriver implements ICoreDrivers {

    public CoreFirefoxBrowser() {
        super();
    }

    @Override
    public String getBrowserType() {
        return browserType;
    }

    @Override
    public WebDriver driver() {
        return driver;
    }

    @Override
    public synchronized WebDriver open() {
        WebDriver driver = launchFirefox(setupFirefox());
        setJavaHook(driver);
        setDriver(driver);
        return driver;
    }

    protected FirefoxOptions setupFirefox() {

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
        return firefoxOptions;
    }

    private WebDriver launchFirefox(FirefoxOptions firefoxOptions) {
        WebDriver webDriver;
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver(firefoxOptions);
        return webDriver;
    }

}
