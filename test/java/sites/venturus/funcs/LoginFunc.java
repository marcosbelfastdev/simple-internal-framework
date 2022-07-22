package sites.venturus.funcs;

import base.tests.BaseSingleDriverFunc;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import sites.venturus.pages.BannerPage;
import sites.venturus.pages.LoginPage;

public class LoginFunc extends BaseSingleDriverFunc {

    public LoginFunc(WebDriver driver) {
        super(driver);
    }


    /**
     * For tests when the initial state can be adjusted to login forcefully
     * @param user
     * @param password
     * @param pageTitle
     */
    public void tryLogin(String user, String password, String pageTitle) {

        var bannerPage = new BannerPage(getBrowser());
        if(bannerPage.isUserAvatarShown()) {
            bannerPage
                    .clickUserAvatar()
                    .clickAvatarLogout();
        }

        new LoginPage(getBrowser())
                .enterUserName(user)
                .enterPassword(password)
                .clickLoginButton();
        Assert.assertNotNull(
                new BannerPage(getBrowser())
                        .getPageTitleElement(pageTitle)
        );

    }

    /**
     * Login when the login page is expected
     * @param user
     * @param password
     * @param pageTitle
     */
    public void loginExpectReady(String user, String password, String pageTitle) {

        Assert.assertTrue(new LoginPage(getBrowser()).isLoginPageShown());

        new LoginPage(getBrowser())
                .enterUserName(user)
                .enterPassword(password)
                .clickLoginButton();
        Assert.assertNotNull(
                new BannerPage(getBrowser())
                        .getPageTitleElement(pageTitle)
        );
        screenshot(getBrowser(), "Page title has been validated: " + pageTitle);
    }
}
