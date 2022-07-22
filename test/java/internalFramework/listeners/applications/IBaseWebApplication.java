package java.internalFramework.listeners.applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

import java.internalFramework.listeners.core.exceptions.QuantityOfBrowsersOverflow;

public interface IBaseWebApplication {

    void startNewBrowser() throws QuantityOfBrowsersOverflow;
    void setCurrentBrowser(Integer browserOrder);
    WebDriver getBrowser();

}
