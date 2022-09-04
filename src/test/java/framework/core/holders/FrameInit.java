package framework.core.holders;

import com.github.marcosbelfastdev.erbium.core.Driver;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class FrameInit {

    Driver driver;
    Class<?> $baseFrameClass;
    Object $baseFrame;

    public FrameInit(Driver driver, Class<?> baseFrameClass) {
        this.driver = driver;
        this.$baseFrameClass = baseFrameClass;
        init(driver, baseFrameClass);
    }

    private FrameInit init(Driver driver, Class<?> baseFrameClass) {
        Constructor[] constructors = baseFrameClass.getDeclaredConstructors();
        try {
            this.$baseFrame = constructors[0].newInstance(driver);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public <T> T getBaseFrame() {
        return (T) $baseFrame;
    }
}
