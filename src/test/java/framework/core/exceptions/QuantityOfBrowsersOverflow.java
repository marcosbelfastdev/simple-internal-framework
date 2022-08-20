package framework.core.exceptions;

public class QuantityOfBrowsersOverflow extends Exception {

    public QuantityOfBrowsersOverflow() {
        super(
                "An attempt was made to instantiate more browsers than the quantity of allowed browsers in the test configuration file."
        );
    }

    public QuantityOfBrowsersOverflow(String message) {
        super(message);
    }

}
