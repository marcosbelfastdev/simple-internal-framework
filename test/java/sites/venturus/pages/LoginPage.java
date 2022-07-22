package sites.venturus.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import sites.venturus.attributes.LoginAttributes;

import static java.util.Objects.isNull;

public class LoginPage extends LoginAttributes {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUserName(String userName) {
        clearSendKeys(login(), userName);
        screenshot("Entered user name.");
        return this;
    }

    public LoginPage enterPassword(String password) {
        clearSendKeys(password(), password);
        screenshot("Entered a password.");
        return this;
    }

    public LoginPage clickLoginButton() {
        screenshot("About to submit the login form...");
        login().submit();
        return this;
    }

    public boolean isLoginPageShown() {
        String login = "Login with your Account";
        String avatar = "ant-avatar-circle";
        String result = waitPageSourceContainAnyText(5, login, avatar);
        screenshot("Check whether the login page is shown.");
        Assert.assertNotNull(result);
        if (result.equals(login))
            return true;
        return !isNull(login());
    }

}
