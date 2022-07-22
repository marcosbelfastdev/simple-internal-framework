package sites.venturus.pages.formItemsElements;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sites.venturus.attributes.BannerAttributes;

public class TreeViewPage extends BasePage {

    public TreeViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageTitleElement(String title) {
        return make.getWebElement(By.linkText(title));
    }



}
