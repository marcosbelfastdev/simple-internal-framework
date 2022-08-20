package framework.core.browsers.single;

import framework.core.driver.WebDriverConstrainer;
import org.openqa.selenium.WebDriver;

import static framework.core.exceptions.Errors.end;

public class BaseBrowser {

    private WebDriver driver;
    protected WebDriverConstrainer webDriverConstrainer;

    public BaseBrowser(WebDriver driver) {
        this.driver = driver;
        this.webDriverConstrainer = new WebDriverConstrainer(driver);
    }

    protected WebDriverConstrainer getWebDriverConstrainer() {
        return webDriverConstrainer;
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
