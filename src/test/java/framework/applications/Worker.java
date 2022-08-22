package framework.applications;


import org.openqa.selenium.remote.BrowserType;

public class Worker implements Runnable {

        FakeLandingPage flp;

        @Override
        public void run() {
            new FakeLandingPage(BrowserType.CHROME).goToBaseUrl();
            System.out.println("Rodando worker...");
        }
    }
