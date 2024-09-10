package service.strategy.billCalculationStrategy;

import models.Bill;
import models.Gate;
import models.Ticket;
import models.enums.BillStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author mdarmanansari
 */
public class SimpleBillCalculationStrategy implements BillCalculationStrategy {
    @Override
    public Bill generateBill(Ticket ticket, Gate gate) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();

        long numberOfSeconds = ChronoUnit.SECONDS.between(exitTime, entryTime);
        long amount = numberOfSeconds * 10;

        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setExitTime(exitTime);
        bill.setStatus(BillStatus.UNPAID);
        bill.setTicket(ticket);
        bill.setExitGate(gate);

        return bill;
    }
}
