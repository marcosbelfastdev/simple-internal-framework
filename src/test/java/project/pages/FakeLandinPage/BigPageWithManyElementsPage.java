package project.pages.FakeLandinPage;

import com.github.marcosbelfastdev.erbium.core.Driver;
import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.base.BasePage;
import org.openqa.selenium.By;

public class BigPageWithManyElementsPage extends BasePage {



    public BigPageWithManyElementsPage(Driver driver) {
        super(driver);
    }

    public final Element name = new Element($driver, By.xpath("//input[@placeholder='Name']"));
    public final Element facebookLink = new Element($driver, By.linkText("Facebook"));


}
