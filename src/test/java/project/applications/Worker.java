package project.applications;


import org.openqa.selenium.remote.BrowserType;

public class Worker implements Runnable {

        FakeLandingPage flp;

        @Override
        public void run() {
            try {
                new FakeLandingPage(BrowserType.CHROME).goToBaseUrl();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
            System.out.println("Rodando worker...");
        }
    }
