package sites.venturus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import sites.venturus.attributes.BannerAttributes;

public class BannerPage extends BannerAttributes {

    public BannerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageTitleElement(String title) {
        screenshot("Getting page title element...");
        return make.getWebElement(By.linkText(title));
    }

    /**
     * CLick on the n-th page link on banner frame
     * N corresponds to the page number as in:
     * Page 1, Page 2, Page 3...
     * @param n
     * @return
     */
    public BannerPage clickPageN(int n) {
        screenshot("About to click on Page" + n + ".");
        clickInteractableElement(pageLinks().get(n-1));
        return this;
    }

    /**
     * Click the circle icon on top right hand
     *
     * @return
     */
    public BannerPage clickUserAvatar() {
        screenshot("About to click on the user avatar.");
        clickInteractableElement(userArea());
        return this;
    }

    /**
     * Click the Logout menu option within avatar circle dropdown
     * @return
     */
    public BannerPage clickAvatarLogout() {
        screenshot("About to click on the logout option.");
        clickInteractableElement(logoutUserItem());
        return this;
    }

    public boolean isUserAvatarShown() {
        screenshot("Checking whether the user avatar circle is shown...");
        String login = "Login with your Account";
        String avatar = "ant-avatar-circle";
        String result = waitPageSourceContainAnyText(5, login, avatar);
        Assert.assertNotNull(result);
        if (result.equals(login))
            return false;
        return isDisplayed(userAreaNoWait());
    }


}
