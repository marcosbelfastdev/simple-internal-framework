package sites.venturus.attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class BannerAttributes extends BasePage {

    public BannerAttributes(WebDriver driver) {
        super(driver);
    }

    final int LOGOUT_ITEM_ORDER_IN_LIST = 2;

    protected List<WebElement> pageLinks() {
        WebElement nav = make.getWebElement(By.xpath("//div/nav[1]"));
        return new ArrayList<>(nav.findElements(By.xpath("//a/span[contains(.,'Page')]")));
    }

    protected WebElement userArea() {
        return make.getInteractableWebElement(By.xpath("//button[@data-cy='userButton']"));
    }

    protected WebElement userAreaNoWait() {
        WebElement element = null;
        List<WebElement> list = new ArrayList<>();
        try {
            list.addAll(driver.findElements(By.xpath("//button[@data-cy='userButton']")));
        } catch (Exception ignore) {

        }
        if (list.size() > 0)
            element = list.get(0);
        return element;
    }

    private List<WebElement> logoutMenu() {
        WebElement list = make.getWebElement(By.xpath("//ul[@role='menu']"));
        return new ArrayList<>(list.findElements(By.xpath("//li")));
    }

    protected WebElement logoutUserItem() {
        return logoutMenu().get(LOGOUT_ITEM_ORDER_IN_LIST);
    }

}
