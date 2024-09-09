package service;

import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSpot;
import models.enums.*;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mdarmanansari
 */
public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public InitialisationService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingLot init() {

        System.out.println("**** Starting Initialisation ****");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("UB City Parking");
        parkingLot.setAddress("UB City, Bangalore");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypesSupported(List.of(VehicleType.TWO_WHEELER, VehicleType.FOUR_WHEELER, VehicleType.EV, VehicleType.LUXURY));

        List<ParkingFloor> floors = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> spots = new ArrayList<>();

            for (int j = 1; j <= 10; j++) {
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(j);
                parkingSpot.setNumber((i * 100) + j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);

                if (j % 2 == 0 && j % 10 != 0) {
                    parkingSpot.setVehicleType(VehicleType.TWO_WHEELER);
                } else if (j % 10 == 0) {
                    parkingSpot.setVehicleType(VehicleType.LUXURY);
                } else if (j % 5 == 0) {
                    parkingSpot.setVehicleType(VehicleType.EV);
                } else {
                    parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                }

                spots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }

            parkingFloor.setParkingSpots(spots);

            Gate entryGate = new Gate();
            entryGate.setId((i * 1000) + 1);
            entryGate.setGateNumber(i * 100 + 1);
            entryGate.setStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperatorName("Operator : " + i + 1);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.put(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId((i * 1000) + 2);
            exitGate.setGateNumber(i * 100 + 2);
            exitGate.setStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperatorName("Operator : " + i + 2);
            parkingFloor.setExitGate(exitGate);
            gateRepository.put(exitGate);

            floors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }

        parkingLot.setFloors(floors);
        parkingLotRepository.put(parkingLot);
        return parkingLotRepository.get(1);

    }
}
