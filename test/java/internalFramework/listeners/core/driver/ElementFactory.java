package java.internalFramework.listeners.core.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementFactory {

    WebDriver driver;
    final int COMMON_RESOLVE_TIME = 60;

    public ElementFactory(WebDriver driver) {
        this.driver = driver;
    }

    public int getCommonResolveTime() {
        return COMMON_RESOLVE_TIME;
    }

    public WebElement getWebElement(By locator) {
        return getWebElement(locator, COMMON_RESOLVE_TIME);
    }

    public WebElement getWebElement(By locator, int resolve) {
        WebElement webElement = null;
        try {
            webElement =  new WebDriverWait(driver, resolve)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception ignore) {

        }
        return webElement;
    }

    public WebElement getInteractableWebElement(By locator) {
        return getInteractableWebElement(locator, COMMON_RESOLVE_TIME);
    }

    public WebElement getInteractableWebElement(By locator, int resolve) {
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(driver, resolve)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception ignore) {

        }
        return webElement;
    }

    public boolean exists(By locator, int resolve) {
        boolean elementExists = false;
        WebElement webElement = null;
        try {
            webElement = new WebDriverWait(driver, resolve)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
            elementExists = true;
        } catch (Exception ignore) {

        }
        return elementExists;
    }

    public boolean exists(By locator) {
        return exists(locator, COMMON_RESOLVE_TIME);
    }

    /*
    private void highlight(WebElement webElement) {
        try {
            unhighlight();
            ((JavascriptExecutor) $driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    webElement, "border: 2px solid springgreen; border-radius: 5px;");
            lastHighlighted = webElement;
        } catch (Exception ignore) { }
    }

    private void unhighlight() {
        if (lastHighlighted != null)
            ((JavascriptExecutor) $driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    lastHighlighted, "");
    }

     */
}
