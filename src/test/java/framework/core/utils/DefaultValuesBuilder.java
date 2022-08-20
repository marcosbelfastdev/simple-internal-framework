package framework.core.utils;

import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class DefaultValuesBuilder {

    public static <T> T defaults(T... objects) {

        for (T object : objects) {

            if (object instanceof Map) {
                return (T) new HashMap<>();
            }

            if (object instanceof List) {
                return (T) new ArrayList<T>();
            }

            if (object instanceof ChromeOptions) {
                return (T) new ChromeOptions();
            }

            if (object instanceof Integer) {
                return (T) Integer.valueOf(0);
            }

            if (object instanceof String) {
                return (T) "";
            }
        }

        return null;
    }

}
