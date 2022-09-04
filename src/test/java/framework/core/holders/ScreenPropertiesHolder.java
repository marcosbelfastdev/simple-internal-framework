package framework.core.holders;

import com.github.marcosbelfastdev.erbium.core.Driver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class ScreenPropertiesHolder implements IHolder {

    Driver $driver;
    Dimension $size;
    Point $location;

    DriverHolder $driverHolder;

    public ScreenPropertiesHolder(Driver driver) {
        // it is assumed current properties are default properties to be restored
        setDriver(driver);
        setDriverHolder(driver);
        setScreenProperties();
    }

    private void setDriver(Driver driver) {
        $driver = driver;
    }

    private void setDriverHolder(Driver driver) {
        $driverHolder = new DriverHolder(driver);
    }

    private void setScreenProperties() {
        setLocation($driver.manage().window().getPosition());
        setSize($driver.manage().window().getSize());
    }

    private void restoreScreenProperties() {
        $driver.getWrappedWebDriver().manage().window().setSize($size);
        $driver.getWrappedWebDriver().manage().window().setPosition($location);
    }

    private void setSize(Dimension size) {
        $size = size;
    }

    private void setLocation(Point location) {
        $location = location;
    }


    public ScreenPropertiesHolder restore() {
        restoreScreenProperties();
        try {
            $driver.reset();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Override
    public ScreenPropertiesHolder call(Object... callables) {
        return null;
    }
}
