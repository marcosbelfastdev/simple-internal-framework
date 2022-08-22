package framework.core.exceptions;

public class BrowserOptionsAbsent extends RuntimeException {

    public BrowserOptionsAbsent() {
        super(
                "FakeLandingPage options were not set before starting it."
        );
    }

    public BrowserOptionsAbsent(String message) {
        super(message);
    }

}
