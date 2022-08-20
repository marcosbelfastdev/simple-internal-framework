package framework.core.exceptions;

public class BrowserUnavailable extends RuntimeException {

    public BrowserUnavailable() {
        super(
                "The browser called is no longer active."
        );
    }

    public BrowserUnavailable(String message) {
        super(message);
    }

}
