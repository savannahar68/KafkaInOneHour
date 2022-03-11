package Exceptions;

public class BrokerException extends Exception{
    public BrokerException() {
        super();
    }

    public BrokerException(String message) {
        super(message);
    }

    public BrokerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrokerException(Throwable cause) {
        super(cause);
    }

    protected BrokerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
