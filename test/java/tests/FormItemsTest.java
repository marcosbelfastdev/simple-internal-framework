package tests;

import sites.venturus.tests.VenturusTest;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sites.venturus.constants.SiteConfig;
import sites.venturus.data.FormItemsData;
import sites.venturus.data.LoginPageData;
import sites.venturus.funcs.FormFieldsFunc;
import sites.venturus.funcs.LoginFunc;
import sites.venturus.funcs.MenuFunc;

public class FormItemsTest extends VenturusTest {

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @BeforeMethod
    public void setup() {
        init(BrowserType.EDGE);
        getBrowser().navigate().to(SiteConfig.URL);
    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void testAllColorsAreSelected() {
        var formFieldsFunc = new FormFieldsFunc(getBrowser());

        new LoginFunc(getBrowser())
                .tryLogin(LoginPageData.login, LoginPageData.password, "Test Automation");
        new MenuFunc(getBrowser())
                .selectPage(SiteConfig.FORM_FIELDS_PAGE);

        formFieldsFunc.selectItemInTreeView(FormItemsData.FORM_ITEMS_LABEL, "Color", "Red");
        formFieldsFunc.selectItemInTreeView(FormItemsData.FORM_ITEMS_LABEL, "Color", " Green");
        formFieldsFunc.selectItemInTreeView(FormItemsData.FORM_ITEMS_LABEL, "Color", "Blue");
    }

}
