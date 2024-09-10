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
public class SurgeBillCalculationStrategy implements BillCalculationStrategy {
    @Override
    public Bill generateBill(Ticket ticket, Gate gate) {
        LocalDateTime exitTime = LocalDateTime.now();

        long numberOfSeconds = ChronoUnit.SECONDS.between(ticket.getEntryTime(), exitTime);

        long amount = 0;
        if (numberOfSeconds > 60) {
            amount = numberOfSeconds * 10;
        } else if (numberOfSeconds > 30) {
            amount = (numberOfSeconds * 10) + numberOfSeconds;
        } else {
            amount = (numberOfSeconds * 10) + (numberOfSeconds * 2);
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
