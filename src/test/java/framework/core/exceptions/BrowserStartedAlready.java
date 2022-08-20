package framework.core.exceptions;

public class BrowserStartedAlready extends RuntimeException {

    public BrowserStartedAlready() {
        super(
                "Cannot start all browsers as at least one browser has started already."
        );
    }

    public BrowserStartedAlready(String message) {
        super(message);
    }

}
