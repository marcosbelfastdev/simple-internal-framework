package sites.venturus.attributes;

import base.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FormItemsAttributes extends BasePage {

    public FormItemsAttributes(WebDriver driver) {
        super(driver);
    }


    final public String HORIZONTAL_LAYOUT = "horizontal";
    final public String VERTICAL_LAYOUT = "vertical";
    final public String INLINE_LAYOUT = "inline";
    final public String RADIO_BUTTON_LABEL = "Radio Button";
    final public String TREESELECT_LABEL = "TreeSelect";

    protected WebElement layoutOption(String label, String value) {
        return make.getWebElement(By.xpath("//label[@title='" + label +
                "']/ancestor::div//input[@value='" + value +
                "']"));
    }

    protected WebElement input() {
        return make.getWebElement(By.xpath("//input[@placeholder='Only letters and numbers are allowed']"));
    }

    protected WebElement countryArrowSelector() {
        //label[@title='Select']/ancestor::div//div[@unselectable='on' and contains(.,'Select a country')]
        return make.getWebElement(By.xpath("//div[contains(.,'Select a country')]/ancestor::span//span/i[@class='anticon anticon-down ant-select-arrow-icon']"));
    }

    protected WebElement countryInputField() {
        return make.getWebElement(By.xpath("//div[contains(.,'Select a country')]/ancestor::div[@role='combobox']"));
    }


    protected WebElement treeSelectCombo(String label) {
        return make.getWebElement(By.xpath("//label[@title='" + label +
                "']/ancestor::form//span[@role='combobox']"));
    }

    protected WebElement treeTopLevelOptionArrow(WebElement treeSelectCombo, String topOption) {

        String ariaControls = treeSelectCombo.getAttribute("aria-controls");
        return make.getWebElement(By.xpath("//div[@id='" + ariaControls +
                "']//span[@title='" + topOption + "']/ancestor::li/span[@class='ant-select-tree-switcher ant-select-tree-switcher_close']/i"));
    }

    protected boolean isCarretOpen(WebElement treeSelectCombo, String topOption) {
        List<WebElement> carretOpen = new ArrayList<>();
        String ariaControls = retrieveWebElement(treeSelectCombo).getAttribute("aria-controls");
        try {
            carretOpen.addAll(driver.findElements(
                    By.xpath("//div[@id='" + ariaControls +
                    "']//span[@title='" + topOption + "']/ancestor::li/span[@class='ant-select-tree-switcher ant-select-tree-switcher_open']/i"))
            );
            if (carretOpen.size() > 0)
                return true;
        } catch (Exception ignore) {

        }
        return false;
    }

    protected WebElement treeSelectOption(WebElement treeSelectCombo, String option) {
        String ariaControls = treeSelectCombo.getAttribute("aria-controls");
        return make.getWebElement(By.xpath("//div[@id='" + ariaControls +
                "']//span[@title='" + option + "']"));
    }






}
