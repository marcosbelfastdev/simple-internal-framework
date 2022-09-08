package project.applications.FakeLanding.pages;

import com.github.marcosbelfastdev.erbium.core.Element;
import framework.core.base.BasePage;
import framework.core.browsers.single.BaseBrowser;
import org.openqa.selenium.By;

public class BigPageWithManyElementsPage extends BasePage {


    public final Element name = new Element($driver, By.xpath("//input[@placeholder='Name']"));



    public BigPageWithManyElementsPage(BaseBrowser baseBrowser) {
        super(baseBrowser);
    }
}
