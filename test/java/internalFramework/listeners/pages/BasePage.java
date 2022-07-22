package base.pages;

import base.tests.BaseTest;
import core.utils.TestReporter;
import core.utils.Timer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.driver.ElementFactory;
import org.testng.Reporter;

import static java.util.Objects.isNull;

public class BasePage {

    protected WebDriver driver;
    protected ElementFactory make;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver, int wait) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, wait);
        this.make = new ElementFactory(driver);
        this.driver = driver;
    }

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.make = new ElementFactory(driver);
        this.wait = new WebDriverWait(driver, make.getCommonResolveTime());
        this.driver = driver;
    }

    protected <T> WebElement retrieveWebElement(T element) {
        if (element instanceof By) {
            return make.getWebElement((By) element);
        }
        return (WebElement) element;
    }

    protected void navigate(String url) {
        driver.navigate().to(url);
    }

    protected WebElement getPageTitleElement(String title) {
        return make.getWebElement(By.xpath("//*[contains(.,'" + title + "')]"));
    }

    protected boolean isDisplayed(WebElement element) {
        return !isNull(element) && element.isDisplayed();
    }

    protected String waitPageSourceContainAnyText(int wait, String... texts) {
        Timer timer = new Timer(wait* 1000L);
        while (!timer.timedOut()) {
            String pageSource = driver.getPageSource();
            for (String text : texts) {
                if (pageSource.contains(text))
                        return text;
                timer.sleep(300);
            }
        }
        return null;
    }

    protected <T> void clearSendKeys(T element, String keys) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(
                retrieveWebElement(element)
        ));
        webElement.clear();
        webElement.sendKeys(keys);
    }

    protected <T> void clickInteractableElement(T element) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(
                retrieveWebElement(element)
        ));
        webElement.click();
    }

    protected <T> void click(WebElement element) {
        element.click();
    }

    protected void jsclick(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    protected void logStep(String message) {
        BaseTest.logStep(message);
    }

    protected void screenshot(String message) {
        BaseTest.screenshot(driver, message);
    }

    protected void scrollToTop() {
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");
    }
    protected void scrollToFindElement(WebElement element, int direction) {
        scrollToFindElement(element, 1, false);
    }

    protected void scrollToFindElement(WebElement element, int direction, boolean top) {

        /*
        direction = direction == 0 ? 1 : direction;
        direction = (int) (direction / Math.abs(direction));
        double searchScrollFactor = 0.4;
        int searchScrollDelay = 2000;
        int offset = (int) (driver.manage().window().getSize().height * searchScrollFactor);

        if (top)
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0);");

        long start = System.currentTimeMillis();
        long elapsed = 0;
        WebElement webElement = null;
        while (elapsed < make.getCommonResolveTime()* 1000L) {
            try {
                try {
                    //if (driver.findElements(by).get(0).isDisplayed()) {
                    if (element.isDisplayed()) {
                        break;
                    }
                } catch (Exception ignore) {

                }
                for (int i = 0; i <= offset; i = i + 7) {
                    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, " + 7 * direction + ");");
                    break;
                }

            } catch (Exception ignore) {

            }

            try {
                Thread.sleep(searchScrollDelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elapsed = System.currentTimeMillis() - start;
        }
        */
    }
}
