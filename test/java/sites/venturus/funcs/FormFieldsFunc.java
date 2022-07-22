package sites.venturus.funcs;

import base.tests.BaseSingleDriverFunc;
import org.openqa.selenium.WebDriver;
import sites.venturus.data.FormItemsData;
import sites.venturus.pages.FormItemsPage;

public class FormFieldsFunc extends BaseSingleDriverFunc {

    public FormFieldsFunc(WebDriver driver) {
        super(driver);
    }

    public void selectLayout(String label, String layout) {
        new FormItemsPage(getBrowser())
                .selectLayout(label, layout);
    }


    public void testInputData(String text) {

        new FormItemsPage(getBrowser())
                .inputDataInInputField(text)
                .validateInputFieldContainsAlphaNumericChars();
    }

    public void testCountrySelection(String... countries) {
        var formItemsPage = new FormItemsPage(getBrowser());
        for (String country : countries) {
            formItemsPage.selectCountry(country);
        }
    }

    public void selectItemInTreeView(String label, String topOption, String subOption) {

        new FormItemsPage(getBrowser())
                .selectTreeViewOption(label, topOption, subOption);

    }

    public void selectItemInTreeView() {
        var formItemsPage = new FormItemsPage(getBrowser());
        formItemsPage
                .selectTreeViewOption(FormItemsData.FORM_ITEMS_LABEL, "Color", "Red")
                .selectTreeViewOption(FormItemsData.FORM_ITEMS_LABEL, "Color", "Green")
                .selectTreeViewOption(FormItemsData.FORM_ITEMS_LABEL, "Color", "Blue");
    }
}
