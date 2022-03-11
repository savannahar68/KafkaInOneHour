package Exceptions;

public class SubscriberException extends Exception{
    public SubscriberException() {
        super();
    }

    public SubscriberException(String message) {
        super(message);
    }

    public SubscriberException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscriberException(Throwable cause) {
        super(cause);
    }

    protected SubscriberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
