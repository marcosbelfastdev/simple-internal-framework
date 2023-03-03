package project.tests;

import framework.core.base.Ssh;
import project.applications.FakeLanding.FakeLandingApp;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SimpleTest {

    FakeLandingApp flp = new FakeLandingApp(BrowserType.CHROME);

    /*
    This test extends a BaseVenturusTest class designed to work with 1 browser.
    Look into that class to check for init() and @AfterMethod test methods.

    It starts the browser at the beginning and tries a logout at the end of the test
    so not to leave the user logged in for the next test run.
     */

    @BeforeTest
    public void setup(ITestContext context) {



    }

    /*
    Ant elements used in this test were created inside the final page object
    in a horizontal manner, without the need for separate page objects, for simplicity reasons.
     */

//    @Test(description = "Demo Test - Test color selection in Treeview")
//    public void firstTest() throws Throwable {
//        flp.goToBaseUrl();
//        flp.driver().setOption(Common.SCREEN_SIZE, new Dimension(700,800));
//        flp.driver().reset();
//        System.out.println("Finished.");
//    }

    @Test(description = "Testar conexão com ssh")
    public void connectSsh() throws InterruptedException, IOException {

        Ssh ssh = new Ssh("10.211.55.9", 22, "parallels", "oinfante", 10000);
        ssh.connect();
        ssh.mtype(
                "ls -la",           Ssh.ENTER,
                "ifconfig",          Ssh.ENTER,
                "ls",               Ssh.ENTER,
                "du / -h",          Ssh.ENTER
        );
        String allResponses = ssh.getAllResponses();
        System.out.println(allResponses);
        String lastResponse = ssh.getLastResponse();
        allResponses = ssh.getAllResponses();
    }

}
