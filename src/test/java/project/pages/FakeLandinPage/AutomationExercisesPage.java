package project.pages.FakeLandinPage;

import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.base.BasePage;
import org.openqa.selenium.By;

public class AutomationExercisesPage extends BasePage {



    public AutomationExercisesPage(Driver driver) {
        super(driver);
    }

    public Element bigPageWithManyElementsLink() throws Throwable {
        return $driver.findFirstElement(By.linkText("Big page with many elements"));
    }

}
