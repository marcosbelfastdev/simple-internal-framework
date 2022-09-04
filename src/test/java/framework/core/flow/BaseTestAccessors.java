package framework.core.flow;

import com.github.marcosbelfastdev.erbium.core.Driver;
import framework.core.holders.DriverHolder;
import framework.core.holders.FramesHolder;
import framework.core.holders.ScreenPropertiesHolder;

public class BaseTestAccessors extends BaseTest {

    public ScreenPropertiesHolder screenHolder(Driver driver) {
        return new ScreenPropertiesHolder(driver);
    }

    public DriverHolder driverHolder(Driver driver) {
        return new DriverHolder(driver);
    }

    public FramesHolder framesHolder(Driver driver, Class<?> clazz) {
        return new FramesHolder(driver, clazz);
    }

}
