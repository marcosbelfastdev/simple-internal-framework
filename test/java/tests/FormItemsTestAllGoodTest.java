package tests;

import sites.venturus.tests.VenturusTest;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sites.venturus.constants.SiteConfig;
import sites.venturus.data.FormItemsData;
import sites.venturus.data.LoginPageData;
import sites.venturus.funcs.BorrowRepaymentChecksFunc;
import sites.venturus.funcs.FormFieldsFunc;
import sites.venturus.funcs.LoginFunc;
import sites.venturus.funcs.MenuFunc;

public class FormItemsTestAllGoodTest extends VenturusTest {

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

    'Func' methods would work as 'flows' to be reused in an actual scenario.
    They do not make a lot of sense here though because the AUT is small.

     */

    @Test(description = "Demo Test - Test color selection in Treeview")
    public void testAll() {
        var formFieldsFunc = new FormFieldsFunc(getBrowser());
        var menuFunc = new MenuFunc(getBrowser());

        new LoginFunc(getBrowser())
                .tryLogin(LoginPageData.login, LoginPageData.password, "Test Automation");

        menuFunc.selectPage(SiteConfig.FORM_FIELDS_PAGE);

        formFieldsFunc.selectLayout("Radio Button", "horizontal");
        formFieldsFunc.testInputData(FormItemsData.CORRECT_INPUT_DATA);
        //formFieldsFunc.testCountrySelection(FormItemsData.COUNTRIES);
        formFieldsFunc.selectItemInTreeView();
        // could've added more here

        formFieldsFunc.selectLayout("Radio Button", "vertical");
        formFieldsFunc.testInputData(FormItemsData.CORRECT_INPUT_DATA);
        //formFieldsFunc.testCountrySelection(FormItemsData.COUNTRIES);
        formFieldsFunc.selectItemInTreeView();
        // could've added more here

        formFieldsFunc.selectLayout("Radio Button", "inline");
        formFieldsFunc.testInputData(FormItemsData.CORRECT_INPUT_DATA);
        //formFieldsFunc.testCountrySelection(FormItemsData.COUNTRIES);
        formFieldsFunc.selectItemInTreeView();
        // could've added more here

       menuFunc.selectPage(SiteConfig.BORROW_REPAYMENT_PAGE);
        new BorrowRepaymentChecksFunc(getBrowser())
                .verifyTableStatesDoNotChangeData();

    }

}
