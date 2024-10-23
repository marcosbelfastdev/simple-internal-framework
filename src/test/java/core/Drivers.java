package core;

import io.appium.java_client.AppiumDriver;

public class Drivers {

    public static ThreadLocal<Drivers> drivers = new ThreadLocal<>();
    AppiumDriver driver;

    public static Drivers getInstance() {
        if (drivers.get() == null)
            drivers.set(new Drivers());
        return drivers.get();
    }

    public void setAppiumDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public AppiumDriver getAppiumDriver() {
        return driver;
    }

}
