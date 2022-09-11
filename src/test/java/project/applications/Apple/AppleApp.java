package project.applications.Apple;

import com.github.marcosbelfastdev.erbium.core.Common;
import framework.core.browsers.single.BaseBrowser;

import java.net.URL;

public class AppleApp extends BaseBrowser {

    public AppleApp(String browserType) {
        super(browserType);
        try {
            setBaseUrl(new URL("http://www.apple.com"));
            driver().setOption(Common.SEARCHSCROLL_FACTOR, 0.20);
        } catch (Exception ignored) {

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public Object beforeQuit() {
//        new AppleHomePage(_driver)
//                .scrollUp()
//                .homeAnchor.click();
//        return this;
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
