package framework.core.browsers.single;

import com.github.marcosbelfastdev.erbium.core.Driver;
import framework.core.driver.CoreChromeDriver;
import framework.core.driver.CoreDriver;
import framework.core.driver.WebDriverConstrainer;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import static framework.core.exceptions.Errors.end;

public class BaseBrowser {

    private Driver _driver;

    public BaseBrowser(String browserType) {
        if (browserType.equals(BrowserType.CHROME)) {
            CoreChromeDriver chrome = new CoreChromeDriver();
            chrome.ignoreCertificateErrors()
                    .enableSafeBrowsing()
                    .enableAutomation()
                    .disableNotifications()
                    .startIncognito()
                    .setPageLoadStrategy(PageLoadStrategy.EAGER)
                    .suppressDownloadPrompt()
                    .allowPopups()
                    .build();
            chrome.open();
            _driver = new Driver(chrome.driver());
        }
    }

    /*
    setBaseUrl(baseUrl)

    open(browserType)
    navigateToBaseUrl()
    centerBrowser()

    getBrowserConstrainer() -> returns a constrainer object
    exposeDriver();

     */

}
