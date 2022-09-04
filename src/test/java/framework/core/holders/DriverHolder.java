package framework.core.holders;

import com.github.marcosbelfastdev.erbium.core.Driver;

public class DriverHolder implements IHolder {

    Driver $driver;

    public DriverHolder(Driver driver) {
        setDriver(driver);
    }

    private void setDriver(Driver driver) {
        $driver = driver;
    }

    public DriverHolder call(Object... callables) {
        return this;
    }

    public DriverHolder restore() {
        try {
            $driver.reset();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
