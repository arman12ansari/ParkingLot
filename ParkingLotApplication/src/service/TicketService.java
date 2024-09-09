package service;

import models.ParkingLot;
import models.ParkingSpot;
import models.Ticket;
import models.Vehicle;
import models.enums.ParkingSpotStatus;
import models.enums.SpotAllocationStrategyName;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import service.strategy.spotAllocationStrategy.SpotAllocationStrategy;
import service.strategy.spotAllocationStrategy.SpotAllocationStrategyFactory;

import java.time.LocalDateTime;

/**
 * @author mdarmanansari
 */
public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository, ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, int parkingLotId) {
        SpotAllocationStrategy strategy = SpotAllocationStrategyFactory.getSpotAllocationStrategy(SpotAllocationStrategyName.NEAREST_SPOT_ALLOCATION_STRATEGY);
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);

        ParkingSpot allocatedSpot = strategy.getSpotForVehicle(parkingLot, vehicle);
        allocatedSpot.setVehicle(vehicle);
        allocatedSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpotRepository.put(allocatedSpot);

        int floorId = allocatedSpot.getNumber() / 100;
        int gateId = (floorId * 1000) + 1;

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(allocatedSpot);
        ticket.setEntryGate(gateRepository.get(gateId));
        ticket.setEntryTime(LocalDateTime.now());

        return ticketRepository.put(ticket);
    }
}
