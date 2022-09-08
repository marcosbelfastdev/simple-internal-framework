package project.applications;


import org.openqa.selenium.remote.BrowserType;
import project.applications.FakeLanding.FakeLandingApp;

public class Worker implements Runnable {

        FakeLandingApp flp;

        @Override
        public void run() {
            try {
                new FakeLandingApp(BrowserType.CHROME).goToBaseUrl();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            System.out.println("Rodando worker...");
        }
    }
