package project.applications.FakeLanding;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.browsers.single.BaseBrowser;

import java.net.URL;

public class FakeLandingApp extends BaseBrowser {

    public FakeLandingApp(String browserType) {
        super(browserType);
        try {
            setBaseUrl(new URL("https://www.ultimateqa.com/fake-landing-page"));
            driver().setOption(Common.SEARCHSCROLL_FACTOR, 0.20);
        } catch (Exception ignored) {

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public Object afterOpen(Object... objects) {
//        if (!(driver().getWrappedWebDriver() instanceof ChromeDriver))
//            driver().manage().window().fullscreen();
//        else
//            driver().manage().window().maximize();
//        return null;
//    }

    /*
    setBaseUrl(baseUrl)

    open(browserType)
    navigateToBaseUrl()
    centerBrowser()

    getBrowserConstrainer() -> returns a constrainer object
    exposeDriver();

     */

}
