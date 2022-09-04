package project.pages.FakeLandinPage;

import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.base.BasePage;
import framework.core.browsers.single.BaseBrowser;
import org.openqa.selenium.By;

public class AutomationExercisesPage extends BasePage {

    public AutomationExercisesPage(BaseBrowser driver) {
        super(driver);
    }

    public final Element bigPageWithManyElementsLink = new Element($driver, By.linkText("Big page with many elements"));

}
