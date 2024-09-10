package service;

import models.Bill;
import models.Gate;
import models.ParkingSpot;
import models.Ticket;
import models.enums.BillCalculationStrategyName;
import models.enums.ParkingSpotStatus;
import repository.*;
import service.strategy.billCalculationStrategy.BillCalculationStrategy;
import service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;

/**
 * @author mdarmanansari
 */
public class BillService {
    private BillRepository billRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;

    public BillService(BillRepository billRepository, ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository, TicketRepository ticketRepository, GateRepository gateRepository) {
        this.billRepository = billRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
    }

    public Bill generateBill(int ticketId) {
        BillCalculationStrategy strategy = BillCalculationStrategyFactory.getBillCalculationStrategy(BillCalculationStrategyName.SURGE_BILL_CALCULATION_STRATEGY);

        Ticket ticket = ticketRepository.get(ticketId);

        int exitGateId = (ticket.getEntryGate().getGateNumber() / 10) * 100 + 2;
        Gate exitGate = gateRepository.get(exitGateId);

        Bill bill = strategy.generateBill(ticket, exitGate);

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSpot.setVehicle(null);

        parkingSpotRepository.updateParkingSpot(parkingSpot);

        return billRepository.put(bill);
    }
}
