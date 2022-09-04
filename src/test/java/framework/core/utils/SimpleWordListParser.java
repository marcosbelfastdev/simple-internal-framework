package framework.core.utils;

public class SimpleWordListParser {

    public static String[] getWords(String text) {
        return text.split(",");
    }

}
