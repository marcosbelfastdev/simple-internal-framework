package internalFramework.core.driver;

public class SimpleWordListParser {

    public static String[] getWords(String text) {
        return text.split(",");
    }

}
