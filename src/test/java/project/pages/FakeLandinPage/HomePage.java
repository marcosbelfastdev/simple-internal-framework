package project.pages.FakeLandinPage;

import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {



    public HomePage(Driver driver) throws Throwable {
        super(driver);
    }

    public final Element automationExercises =
            new Element($driver, By.linkText("Automation Exercises"));
    public final Element facebookLink =
            new Element($driver, By.linkText("Facebook"));

}
