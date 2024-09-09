package service.strategy.spotAllocationStrategy;

import exception.ParkingSpotNotFoundForVehicle;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;
import models.enums.ParkingSpotStatus;

import java.util.List;

/**
 * @author mdarmanansari
 */
public class LinearSpotAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle, int gateId) {
        int floorId = gateId / 1000;
        ParkingFloor parkingFloor = parkingLot.getFloors().get(floorId - 1);

        if (parkingFloor != null) {
            List<ParkingSpot> parkingSpots = parkingFloor.getParkingSpots();
            if (parkingSpots != null && !parkingSpots.isEmpty()) {
                for (ParkingSpot parkingSpot : parkingSpots) {
                    if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                            && parkingSpot.getVehicleType().equals(vehicle.getVehicleType())) {
                        return parkingSpot;
                    }
                }
            }

        }

        throw new ParkingSpotNotFoundForVehicle("Parking spot not found for vehicle");
    }
}
