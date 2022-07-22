package java.internalFramework.listeners.core.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleWordListParser {

    public static String[] getWords(String text) {
        return text.split(", \t");
    }

}
