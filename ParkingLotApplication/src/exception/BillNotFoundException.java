package exception;

/**
 * @author mdarmanansari
 */
public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException() {
        super();
    }

    public BillNotFoundException(String message) {
        super(message);
    }

    public BillNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BillNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BillNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
