package core.utils;

import java.util.Random;

import static java.util.Objects.isNull;

public class WordsGenerator {

    public static String getRandomString(int size) {
        if (isNull(size))
            size = 20;
        Random random = new Random();
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 20;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String getRandomString() {
        return getRandomString(20);
    }

    private static String createRandomStringOfSize(int size) {

        return "";
    }

    private static String createRandomNumbersOfSize(int size) {
        return "";
    }

    private static String createAnyRandomCharsOfSize(int size) {
        return "";
    }

}
