package framework.core.base;

import com.github.marcosbelfastdev.erbium.core.Driver;
import framework.core.browsers.single.BaseBrowser;

public class BasePage {

    protected Driver $driver;

    public BasePage(Driver driver) {
        setDriver(driver);
    }

    public BasePage(BaseBrowser baseBrowser) {
        setDriver(baseBrowser.driver());
    }

    private void setDriver(Driver driver) {
        $driver = driver;
    }
}
