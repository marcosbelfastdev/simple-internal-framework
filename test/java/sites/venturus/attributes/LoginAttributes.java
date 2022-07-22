package sites.venturus.attributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.pages.BasePage;

public class LoginAttributes extends BasePage {

    public LoginAttributes(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "normal_login_username")
    private WebElement baseLogin;

    @FindBy(id = "normal_login_password")
    private WebElement basePassword;

    public WebElement login() {
        return baseLogin;
    }

    protected WebElement password() {
        return basePassword;
    }

    protected WebElement submit() {
        return make.getInteractableWebElement(By.xpath("//button/span[contains(.,'Log in') or @type='submit']"));
    }
}
