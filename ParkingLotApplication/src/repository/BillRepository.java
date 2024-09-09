package repository;

import exception.BillNotFoundException;
import models.Bill;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mdarmanansari
 */
public class BillRepository {
    private Map<Integer, Bill> billMap;
    private static int idCounter = 0;

    public BillRepository() {
        this.billMap = new HashMap<>();
    }

    public Bill get(int billId) {
        Bill bill = billMap.get(billId);

        if (bill == null) {
            throw new BillNotFoundException("Bill not found with id: " + billId);
        }
        return bill;
    }

    public void put(Bill bill) {
        bill.setId(++idCounter);
        billMap.put(bill.getId(), bill);
        System.out.println("Bill has been added successfully");
    }
}
