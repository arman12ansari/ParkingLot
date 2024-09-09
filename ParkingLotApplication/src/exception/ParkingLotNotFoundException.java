package exception;

/**
 * @author mdarmanansari
 */
public class ParkingLotNotFoundException extends RuntimeException {
    public ParkingLotNotFoundException() {
        super();
    }

    public ParkingLotNotFoundException(String message) {
        super(message);
    }

    public ParkingLotNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingLotNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ParkingLotNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
