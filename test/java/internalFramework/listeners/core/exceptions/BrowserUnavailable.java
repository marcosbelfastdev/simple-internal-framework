package java.internalFramework.listeners.core.exceptions;

public class BrowserUnavailable extends Exception {

    public BrowserUnavailable() {
        super(
                "The browser called is no longer active."
        );
    }

    public BrowserUnavailable(String message) {
        super(message);
    }

}
