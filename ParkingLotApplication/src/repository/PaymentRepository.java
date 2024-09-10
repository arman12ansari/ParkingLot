package repository;

import exception.PaymentNotFoundException;
import models.Payment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mdarmanansari
 */
public class PaymentRepository {
    private Map<Integer, Payment> paymentMap;
    private static int idCounter = 0;

    public PaymentRepository() {
        this.paymentMap = new HashMap<>();
    }

    public Payment get(int paymentId) {
        Payment payment = paymentMap.get(paymentId);

        if (payment == null) {
            throw new PaymentNotFoundException("Payment not found with id: " + paymentId);
        }
        return payment;
    }

    public Payment put(Payment payment) {
        payment.setId(++idCounter);
        paymentMap.put(payment.getId(), payment);
        System.out.println("Payment Details has been added successfully");

        return paymentMap.get(payment.getId());
    }
}
