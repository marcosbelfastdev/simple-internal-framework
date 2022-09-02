package project.applications.applications;

import framework.core.browsers.single.BaseBrowser;

import java.net.URL;

public class GoogleApplication extends BaseBrowser {
    public GoogleApplication(String browserType) {
        super(browserType);
        try {
            setBaseUrl(new URL("https://www.google.com"));
        } catch (Exception ignored) {

        }
    }


}
