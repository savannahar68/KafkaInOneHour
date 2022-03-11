package Exceptions;

public class PublisherException extends Exception{
    public PublisherException() {
        super();
    }

    public PublisherException(String message) {
        super(message);
    }

    public PublisherException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublisherException(Throwable cause) {
        super(cause);
    }

    protected PublisherException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
