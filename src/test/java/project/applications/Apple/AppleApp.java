package project.applications.Apple;

import framework.core.browsers.single.BaseBrowser;

import java.net.URL;

public class AppleApp extends BaseBrowser {

    public AppleApp(String browserType) {
        super(browserType);
        try {
            setBaseUrl(new URL("http://www.apple.com"));
        } catch (Exception ignored) {

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
