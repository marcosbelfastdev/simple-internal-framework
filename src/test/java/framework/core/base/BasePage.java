package framework.core.base;

import com.github.marcosbelfastdev.erbium.core.Driver;

public class BasePage {

    protected Driver $driver;

    public BasePage(Driver driver) {
        setDriver(driver);
    }

    private void setDriver(Driver driver) {
        $driver = driver;
    }
}
