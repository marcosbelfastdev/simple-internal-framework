package framework.core.browsers.single;

import com.github.marcosbelfastdev.erbium.core.Driver;
import framework.core.driver.BasicChromeWebDriver;
import framework.core.driver.BasicFirefoxWebDriver;
import framework.core.driver.BasicWebDriver;
import org.openqa.selenium.PageLoadStrategy;
import java.net.URL;
import static java.util.Objects.isNull;

public class BaseBrowser implements IBaseBrowser {

    private Driver _driver;
    private BasicWebDriver _basic;
    private String _browserType;
    private URL _baseUrl;

    public BaseBrowser(String browserType) {
        setBrowserType(browserType);
    }

    private void setBrowserType(String browserType) {
        _browserType = browserType;
    }

    private String getBrowserType() {
        return _browserType;
    }

    public void setBaseUrl(URL baseUrl) {
        _baseUrl = baseUrl;
    }

    private void configureBrowser() {
        switch (_browserType) {
            case "chrome":
                _basic = new BasicChromeWebDriver();
                ((BasicChromeWebDriver)_basic).ignoreCertificateErrors()
                        .enableSafeBrowsing()
                        .enableAutomation()
                        .disableNotifications()
                        .startIncognito()
                        .setPageLoadStrategy(PageLoadStrategy.EAGER)
                        .suppressDownloadPrompt()
                        .allowPopups()
                        .build();
                break;
            case "firefox" :
                _basic = new BasicFirefoxWebDriver();
                ((BasicFirefoxWebDriver)_basic).setupFirefox();
                break;
        }

    }

    @Override
    public void goToBaseUrl() {
        if (isNull(_basic)) {
            open();
        }
        beforeGoToBaseUrl();
        if (!isNull(_baseUrl))
            _driver.navigate().to(_baseUrl);
        else
            _driver.get("about:blank");
    }

    @Override
    public void open() {
        if (isNull(_basic)) {
            configureBrowser();
        }
        switch (_browserType) {
            case "chrome":
                ((BasicChromeWebDriver)_basic).open();
                break;
            case "firefox" :

                ((BasicFirefoxWebDriver)_basic).open();
                break;
        }
        _driver = new Driver(_basic.driver());
        afterOpen();
    }

    public Driver driver() {
        return _driver;
    }

    @Override
    public void restart() {
        if(isNull(_driver))
            open();
        else {
            quit();
            open();
        }
    }

    public void quit() {
        if (!isNull(_driver))
            _driver.quit();
        afterQuit();
    }

    protected Object beforeGoToBaseUrl(Object... objects) {

        return this;
    }

    protected Object afterOpen(Object... objects) {

        return this;
    }

    protected Object afterQuit(Object... objects) {

        return this;
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
