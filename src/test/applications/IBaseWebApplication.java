package applications;

import org.openqa.selenium.WebDriver;

import internalFramework.core.exceptions.QuantityOfBrowsersOverflow;

public interface IBaseWebApplication {

    void startNewBrowser() throws QuantityOfBrowsersOverflow;
    void setCurrentBrowser(Integer browserOrder);
    WebDriver getBrowser();

}
