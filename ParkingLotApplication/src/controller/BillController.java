package controller;

import models.Bill;
import service.BillService;

/**
 * @author mdarmanansari
 */
public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill generateBill(int ticketId) {
        return billService.generateBill(ticketId);
    }
}
