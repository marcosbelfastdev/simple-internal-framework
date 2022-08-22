package resources.runners;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Runner {

        public static void main(String[] args) {

            /*
            Please be careful with spelling or TestNG will put a spell on the execution :D
             */
            String[] testsToRun =
                    {
//                            "tests.InputDataFailTest"
//                            "tests.FormItemsTestAllGoodTest",
//                            "tests.FormItemsTest"
                            "tests.SimpleTest"
//                            "tests.LoginForcefully"
                    };

            XmlSuite suite = new XmlSuite();
            TestNG testng = new TestNG();
            LocalDateTime now = LocalDateTime.now();
            suite.setName("Venturus Suite " + now.getMonth() + "." + now.getDayOfMonth() + "_" + now.getHour() + "." + now.getMinute() + ".." + now.getSecond());
            suite.addListener("java.internalFramework.listeners.BaseListener");

            XmlTest test = new XmlTest(suite);
            test.setName("AllTestsInArrayAbove");
            List<XmlClass> classes = new ArrayList<>();

            for (String testToRun : testsToRun) {
                classes.add(new XmlClass(testToRun));
            }

            test.setXmlClasses(classes);

            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            suites.add(suite);

            testng.setXmlSuites(suites);
            testng.run();
        }
}
