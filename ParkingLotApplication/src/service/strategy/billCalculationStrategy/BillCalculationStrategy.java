package service.strategy.billCalculationStrategy;

import models.Bill;
import models.Gate;
import models.Ticket;

/**
 * @author mdarmanansari
 */
public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket, Gate gate);
}
