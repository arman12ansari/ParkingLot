package service.strategy.spotAllocationStrategy;

import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

/**
 * @author mdarmanansari
 */
public interface SpotAllocationStrategy {
    ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle, int gateId);
}
