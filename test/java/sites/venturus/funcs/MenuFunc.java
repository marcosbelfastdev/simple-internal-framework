package sites.venturus.funcs;

import base.tests.BaseSingleDriverFunc;
import org.openqa.selenium.WebDriver;
import sites.venturus.pages.BannerPage;

public class MenuFunc extends BaseSingleDriverFunc {

    public MenuFunc(WebDriver driver) {
        super(driver);
    }

    public void selectPage(int page) {
        new BannerPage(getBrowser())
                .clickPageN(page);
    }
}
