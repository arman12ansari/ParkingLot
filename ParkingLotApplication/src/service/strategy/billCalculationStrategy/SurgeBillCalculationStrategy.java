package service.strategy.billCalculationStrategy;

import models.Bill;
import models.Gate;
import models.ParkingLot;
import models.Ticket;
import models.enums.BillStatus;
import repository.ParkingLotRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author mdarmanansari
 */
public class SurgeBillCalculationStrategy implements BillCalculationStrategy {
    @Override
    public Bill generateBill(Ticket ticket, Gate gate, ParkingLot parkingLot, ParkingLotRepository parkingLotRepository) {
        LocalDateTime exitTime = LocalDateTime.now();

        long numberOfSeconds = ChronoUnit.SECONDS.between(exitTime, ticket.getEntryTime());

        int totalCapacity = parkingLot.getCapacity();
        int currentCapacity = parkingLotRepository.currentCapacity();

        long surgeFactor = (long) currentCapacity / (long) totalCapacity;

        long amount = 0;
        if (surgeFactor < 0.02) {
            amount = numberOfSeconds * 10;
        } else {
            amount = (numberOfSeconds * 10) + (numberOfSeconds * 10 * surgeFactor);
        }

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setExitTime(exitTime);
        bill.setStatus(BillStatus.UNPAID);
        bill.setTicket(ticket);
        bill.setExitGate(gate);

        return bill;
    }
}
