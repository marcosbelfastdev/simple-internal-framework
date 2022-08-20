package framework.core.driver;

import framework.core.exceptions.BrowserOptionsAbsent;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.*;

import static framework.core.exceptions.Errors.end;
import static java.util.Objects.isNull;

public class CoreChromeDriver extends CoreDriver implements ICoreDrivers, IChromeBuilder {

    ChromeOptions options;
    HashMap<String, Object> prefs;
    Boolean built;

    private void setOptions() {
        if (isNull(options))
            this.options = new ChromeOptions();
    }

    private void setPrefs() {
        if (isNull(prefs))
            this.prefs = new HashMap<>();
    }

    public CoreChromeDriver() {
        super();
        setOptions();
        setPrefs();
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
        if (isNull(built))
            end(BrowserOptionsAbsent.class);
        WebDriver driver = launchChrome(options);
        setJavaHook(driver);
        setDriver(driver);
        return driver;
    }

    private WebDriver launchChrome(ChromeOptions chromeOptions) {
        WebDriver webDriver;
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(chromeOptions);
        return webDriver;
    }

    @Override
    public IChromeBuilder addCustomOptionArgument(Object argument) {
        options.addArguments((String) argument);
        return this;
    }

    @Override
    public IChromeBuilder addCustomPreference(Object pref, Object value) {
        prefs.putIfAbsent((String) pref, value);
        return this;
    }

    @Override
    public CoreChromeDriver disableNotifications() {
        options.addArguments(DISABLE_NOTIFICATIONS);
        return this;
    }

    @Override
    public CoreChromeDriver startIncognito() {
        options.addArguments(START_INCOGNITO);
        return this;
    }

    @Override
    public CoreChromeDriver ignoreCertificateErrors() {
        options.addArguments(IGNORE_CERTIFICATE_ERRORS);
        return this;
    }

    @Override
    public CoreChromeDriver enableAutomation() {
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        return this;
    }

    @Override
    public CoreChromeDriver enableSafeBrowsing() {
        prefs.put(SAFE_BROWSING_ENABLED, true);
        return this;
    }

    @Override
    public CoreChromeDriver allowPopups() {
        /*
        have to remember or research what this really does
         */
        prefs.put(PROFILE_DEFAULT_SETTINGS_POPUP, 0);
        return this;
    }

    @Override
    public CoreChromeDriver suppressDownloadPrompt() {
        prefs.put(PROMPT_FOR_DOWNLOAD, false);
        return this;
    }

    @Override
    public CoreChromeDriver setPageLoadStrategy(PageLoadStrategy strategy) {
        options.setPageLoadStrategy(strategy);
        return this;
    }

    @Override
    public CoreChromeDriver setDownloadDirectory(File directory) {
        prefs.put(DOWNLOAD_DIRECTORY, directory);
        return this;
    }

    @Override
    public void build() {
        if (!prefs.isEmpty())
            options.setExperimentalOption("prefs", prefs);
        built = true;
    }

}
