package java.internalFramework.listeners.applications;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;

import java.internalFramework.listeners.core.exceptions.*;
import java.internalFramework.listeners.core.driver.DriverManager;
import java.internalFramework.listeners.core.driver.SimpleWordListParser;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.internalFramework.listeners.core.exceptions.Errors.end;
import static java.util.Objects.isNull;

public class BaseWebApplication extends BaseWebApplicationPoints implements IBaseWebApplication {

    // any number of browsers are allowed
    // however, 3 would be a maximum expected and therefore deserve mnemonics
    // from within the framework for easy handling
    final static int MAIN_BROWSER = 0;
    final static int SECOND_BROWSER = 1;
    final static int THIRD_BROWSER = 2;


    Map<Integer, DriverManager> dmMap = new ConcurrentHashMap<>();
    Map<Integer, String> expectedBrowsers = new ConcurrentHashMap<>();
    Integer currentBrowser;

    public BaseWebApplication(ITestContext context) {
        setExpectedBrowsers(context);
    }

    private int getCurrentBrowser() {
        return currentBrowser;
    }

    private int getNumberOfInstantiatedBrowsers() {
        int noib = 0;
        for(DriverManager dm : dmMap.values()) {
            if (!isNull(dm))
                noib++;
        }
        return noib;
    }

    private void setExpectedBrowsers(ITestContext context) {
        String[] expectedBrowsers = SimpleWordListParser.getWords(
                context.getCurrentXmlTest().getAllParameters().get("browserTypes")
        );
        int count = 0;
        for(String expectedBrowser : expectedBrowsers) {
            this.expectedBrowsers.put(count, expectedBrowser);
            count++;
        }
    }

    private Map<Integer, String> getExpectedBrowsers() {
        return this.expectedBrowsers;
    }

    public void startNewBrowser() {
        int noib = getNumberOfInstantiatedBrowsers();
        if (noib == expectedBrowsers.size())
            end(QuantityOfBrowsersOverflow.class);
        var dm = new DriverManager(
                expectedBrowsers.get(noib)
        );
        dmMap.put(noib, dm);
        setCurrentBrowser(noib);
    }

    public void startAllBrowsers() {
        if (getNumberOfInstantiatedBrowsers() > 0)
                end(BrowserStartedAlready.class);
        for(String expectedBrowser : expectedBrowsers.values()) {
            startNewBrowser();
        }
    }

    public void restartCurrentBrowser() {
        doBeforeRestartBrowser();
        dmMap.get(currentBrowser).quit();
        var dm = new DriverManager(
                expectedBrowsers.get(currentBrowser)
        );
        dmMap.replace(currentBrowser, dm);
        doAfterRestartBrowser();
    }

    public void quitBrowser() {
        try {
            doBeforeQuitBrowser();
        } catch (Throwable ignored) {

        }
        dmMap.get(currentBrowser).quit();
        dmMap.replace(currentBrowser, null);
        try {
            doAfterQuitBrowser();
        } catch (Throwable ignored) {

        }
    }

    public void quitAllBrowsers() {
        for(Integer key : dmMap.keySet()) {
            dmMap.get(key).quit();
            dmMap.replace(key, null);
        }
        setCurrentBrowser(null);
    }

    @Override
    public void setCurrentBrowser(Integer browserIndex) {
        if (isNull(browserIndex))
            end(NullPointerException.class);
        browserIndex = browserIndex < 0 ? browserIndex * (-1) : browserIndex;

        final String MESSAGE = "Browser index: " + browserIndex;
        // calling a browser that never started (out of upper bound)
        if (browserIndex > expectedBrowsers.size() - 1) {
            end(BrowserNeverStarted.class, MESSAGE);
        }
        // calling a legal browser index, but browser ended
        if (isNull(dmMap.get(browserIndex)))
            end(BrowserUnavailable.class, MESSAGE);
        this.currentBrowser = browserIndex;
    }

    @Override
    public WebDriver getBrowser() {
        if (isNull(currentBrowser))
            end(BrowserUnavailable.class);
        return dmMap.get(currentBrowser).driver();
    }
}
