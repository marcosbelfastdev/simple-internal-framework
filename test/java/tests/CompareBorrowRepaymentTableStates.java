package tests;

import base.tests.BaseTest;
import org.testng.annotations.BeforeClass;
import sites.venturus.tests.VenturusTest;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sites.venturus.constants.SiteConfig;
import sites.venturus.data.LoginPageData;
import sites.venturus.funcs.BorrowRepaymentChecksFunc;
import sites.venturus.funcs.LoginFunc;
import sites.venturus.funcs.MenuFunc;

public class CompareBorrowRepaymentTableStates extends VenturusTest {

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @BeforeClass(dependsOnMethods = "setup")
    public void setupTestClass() {
        test = BaseTest.getExtentReports().createTest(this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void setup() {
        init(BrowserType.FIREFOX);
        getBrowser().navigate().to(SiteConfig.URL);
    }

    /*
    This test shows custom elements such as the paginating element in the lower right hand of the AUT.
    This is not what I did, but I could've created more and more page objects to handle it,
    however, a more sophisticated approach would be necessary in real life,
    such as creating another layer on top of Selenium and wrap the webdriver and elements
    into custom base webdrivers and custom elements. This would also remove the need for
    an extensive BasePage (as objects would have all the methods and behaviors WITH them).
    This is the idea behind my own framework here:

    www.erbiumframework.org

    These custom elements could be extended to create new custom 'Ant' elements
    similar to page objects, however, they would have their own methods.
    The problem with this approach is it is time-consuming and would have to be tested extensively.
    This would NOT amount to having page objects within page objects, and both the base elements
    and custom Ant elements could have versioning in a way that changes to them would not affect
    any existing test unless the test script was changed to consume new versions.

    The same Ant elements issue will occur again in other pages, but as with Selenium, there is
    no much workaround but creating new custom elements or page objects for non-standard HTML elements.
     */

    @Test(description = "Demo Test - Compare Borrow/Repayment table states")
    public void testBorrowRepayment() {
        new LoginFunc(getBrowser())
                .tryLogin(LoginPageData.login, LoginPageData.password, "Test Automation");
        new MenuFunc(getBrowser())
                .selectPage(SiteConfig.BORROW_REPAYMENT_PAGE);
        new BorrowRepaymentChecksFunc(getBrowser())
                .verifyTableStatesDoNotChangeData();
    }

}
