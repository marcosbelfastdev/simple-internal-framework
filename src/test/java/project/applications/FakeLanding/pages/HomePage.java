package project.applications.FakeLanding.pages;

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

    public final Element automationExercises =
            new Element($driver, By.linkText("Automation Exercises"));
    public final Element facebookLink =
            new Element($driver, By.linkText("Facebook"));

}
