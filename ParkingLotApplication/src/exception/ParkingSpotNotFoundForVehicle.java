package exception;

/**
 * @author mdarmanansari
 */
public class ParkingSpotNotFoundForVehicle extends RuntimeException {
    public ParkingSpotNotFoundForVehicle() {
        super();
    }

    public ParkingSpotNotFoundForVehicle(String message) {
        super(message);
    }

    public ParkingSpotNotFoundForVehicle(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingSpotNotFoundForVehicle(Throwable cause) {
        super(cause);
    }

    protected ParkingSpotNotFoundForVehicle(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
