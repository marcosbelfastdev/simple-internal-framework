package framework.core.exceptions;

public class BrowserNeverStarted extends RuntimeException {

    public BrowserNeverStarted() {
        super(
                "The browser called was never started."
        );
    }

    public BrowserNeverStarted(String message) {
        super(message);
    }

}
