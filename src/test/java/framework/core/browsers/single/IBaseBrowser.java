package framework.core.browsers.single;

import org.openqa.selenium.WebDriver;

public interface IBaseBrowser {

    void startBrowser();
    WebDriver getBrowser();

}
