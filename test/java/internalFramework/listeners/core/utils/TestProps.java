package core.utils;

public class TestProps {

    String testName;
    String testDescription;

    protected TestProps setTestName(String name) {
        testName = name;
        return this;
    }

    protected TestProps setTestDescription(String description) {
        testDescription = description;
        return this;
    }

}
