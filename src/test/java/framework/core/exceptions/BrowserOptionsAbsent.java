package framework.core.exceptions;

public class BrowserOptionsAbsent extends RuntimeException {

    public BrowserOptionsAbsent() {
        super(
                "Browser options were not set before starting it."
        );
    }

    public BrowserOptionsAbsent(String message) {
        super(message);
    }

}
