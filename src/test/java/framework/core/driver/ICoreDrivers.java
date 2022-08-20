package framework.core.driver;

import org.openqa.selenium.WebDriver;

public interface ICoreDrivers {
     WebDriver open();
     String getBrowserType();
     WebDriver driver();
}
