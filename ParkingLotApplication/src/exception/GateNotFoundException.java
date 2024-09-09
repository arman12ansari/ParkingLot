package exception;

/**
 * @author mdarmanansari
 */
public class GateNotFoundException extends RuntimeException {

    public GateNotFoundException() {
        super();
    }

    public GateNotFoundException(String message) {
        super(message);
    }

    public GateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GateNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GateNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
