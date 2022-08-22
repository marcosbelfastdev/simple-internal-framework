package framework.applications;

import framework.core.browsers.single.BaseBrowser;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class FakeLandingPage extends BaseBrowser {

    public FakeLandingPage(String browserType) {
        super(browserType);
        try {
            setBaseUrl(new URL("https://www.ultimateqa.com/fake-landing-page"));
        } catch (Exception ignored) {

        }
    }

    @Override
    public Object afterOpen(Object... objects) {
        if (!(driver().getWrappedWebDriver() instanceof ChromeDriver))
            driver().manage().window().fullscreen();
        else
            driver().manage().window().maximize();
        return null;
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
