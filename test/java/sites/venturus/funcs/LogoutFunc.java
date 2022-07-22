package sites.venturus.funcs;

import base.tests.BaseSingleDriverFunc;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import sites.venturus.pages.BannerPage;
import sites.venturus.pages.LoginPage;

public class LogoutFunc extends BaseSingleDriverFunc {

    public LogoutFunc(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        if (new BannerPage(getBrowser()).isUserAvatarShown()) {
            new BannerPage(getBrowser())
                    .clickUserAvatar()
                    .clickAvatarLogout();
        }

        Assert.assertNotNull(
                new LoginPage(getBrowser())
                        .login()
        );
    }
}
