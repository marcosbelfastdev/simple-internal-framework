package core.utils;

public class Attempts {

    private final int initialAttempts;
    private int currentAttemptCount;

    public Attempts(int attempts) {
        initialAttempts = attempts;
        currentAttemptCount = 0;
    }

    public Attempts start() {
        if (currentAttemptCount > 0)
            return this;
        currentAttemptCount++;
        return this;
    }

    public boolean hasMoreToGo() {
        boolean hasMoreToGo = currentAttemptCount < initialAttempts;
        currentAttemptCount++;
        return hasMoreToGo;
    }
}
