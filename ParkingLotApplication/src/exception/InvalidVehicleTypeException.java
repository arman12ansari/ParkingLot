package exception;

/**
 * @author mdarmanansari
 */
public class InvalidVehicleTypeException extends RuntimeException {
    public InvalidVehicleTypeException() {
        super();
    }

    public InvalidVehicleTypeException(String message) {
        super(message);
    }

    public InvalidVehicleTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVehicleTypeException(Throwable cause) {
        super(cause);
    }

    protected InvalidVehicleTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
