package project.applications.Apple.pages;

import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.base.BasePage;
import framework.core.browsers.single.BaseBrowser;
import org.openqa.selenium.By;

public class HomePage extends BasePage {



    public HomePage(Driver driver) {
        super(driver);
    }

    public HomePage(BaseBrowser baseBrowser) {
        super(baseBrowser.driver());
    }

    public final Element contactApple =
            new Element($driver, By.linkText("Contact Apple"));
}
