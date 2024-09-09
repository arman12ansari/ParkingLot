package service.strategy.billCalculationStrategy;

import models.Bill;
import models.Gate;
import models.ParkingLot;
import models.Ticket;
import repository.ParkingLotRepository;

/**
 * @author mdarmanansari
 */
public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket, Gate gate, ParkingLot parkingLot, ParkingLotRepository parkingLotRepository);
}
