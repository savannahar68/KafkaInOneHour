package Exceptions;

public class BrokerDaoException extends Exception{
    public BrokerDaoException() {
        super();
    }

    public BrokerDaoException(String message) {
        super(message);
    }

    public BrokerDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public BrokerDaoException(Throwable cause) {
        super(cause);
    }

    protected BrokerDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
