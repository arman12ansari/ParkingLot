package exception;

/**
 * @author mdarmanansari
 */
public class ParkingFloorNotFoundException extends RuntimeException {

    public ParkingFloorNotFoundException() {
        super();
    }

    public ParkingFloorNotFoundException(String message) {
        super(message);
    }

    public ParkingFloorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingFloorNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ParkingFloorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
