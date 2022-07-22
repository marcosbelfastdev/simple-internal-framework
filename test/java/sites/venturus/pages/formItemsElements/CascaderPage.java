package sites.venturus.pages.formItemsElements;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CascaderPage extends BasePage {

    public CascaderPage(WebDriver driver) {
        super(driver);
    }

    public CascaderPage setComboElement(WebElement combo) {

        return this;
    }

    public CascaderPage setCascaderPickerLabel(WebElement picker) {

        return this;
    }

    public CascaderPage setCascaderMenus(By ulMenus) {

        // items (li) in each menu will be the options within ul

        return this;
    }



}
