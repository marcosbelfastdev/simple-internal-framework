package sites.venturus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sites.venturus.attributes.FormItemsAttributes;

public class FormItemsPage extends FormItemsAttributes {

    public FormItemsPage(WebDriver driver) {
        super(driver);
    }

    public FormItemsPage selectLayout(String label, String value) {
        jsclick(layoutOption(label, value));
        screenshot("Selected layout: " + value);
        return this;
    }

    public FormItemsPage inputDataInInputField(String text) {
        clearSendKeys(input(), text);
        screenshot("Entered text in input field: \n" + text);
        return this;
    }

    public FormItemsPage validateInputFieldContainsAlphaNumericChars() {
        String errorMessage = "Text contains non-alphanumeric characters!";
        try {
            Assert.assertTrue(input().getText().matches("[a-zA-Z0-9]+"));
        } catch (AssertionError e) {
            logStep("Text does not contain alphanumeric characters ONLY! Check previous logs or screenshots for confirmation.");
        }
        return this;
    }

    public FormItemsPage selectTreeViewOption(String label, String topOption, String subOption) {
        screenshot("Select treeview on label " + label + ", then select option path: " + topOption + " > " + subOption);
        WebElement treeSelectCombo = treeSelectCombo(label);
        click(treeSelectCombo);
        screenshot("Clicked combo.");
        if (!isCarretOpen(treeSelectCombo, topOption)) click(treeTopLevelOptionArrow(treeSelectCombo, topOption));
        screenshot("Clicked top option: " + topOption);
        click(treeSelectOption(treeSelectCombo, subOption));
        screenshot("Final option selected: " + subOption);
        return this;
    }

    public FormItemsPage selectCountry(String country) {
//        click(countryArrowSelector());
//        clearSendKeys(countryInputField(), country);
        return this;
    }

    public FormItemsPage validateFormFieldsPageShown() {
        return this;
    }

}
