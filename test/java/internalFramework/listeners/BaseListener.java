package base.listeners;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.time.LocalDateTime;
import java.util.List;

public class BaseListener implements
        ITestListener, ISuiteListener {


    public void onStart(ISuite suite) {
        System.out.println("onStart suite context");
    }

    public void onStart(ITestContext context) {
        System.out.println("onStart test context");
    }

    public void onTestStart(ITestContext context) {
        System.out.println("onTestStart test context");
    }

    public void onTestStart(ISuite suite) {
        System.out.println("onTestStart suite context");
    }

    public void onTestFinish(ITestContext context) {
       System.out.println("onTestFinish test context");
    }

    public void onTestFinish(ISuite suite) {
        System.out.println("onTestFinished suite context");
    }

    public void onFinish(ISuite suite) {
        System.out.println("onFinish suite context");
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish test context");
    }

}
