package controller;

import models.Bill;
import models.Payment;
import service.PaymentService;

/**
 * @author mdarmanansari
 */
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public Payment makePayment(int paymentOption, Bill bill) {
        return paymentService.makePayment(paymentOption, bill);
    }
}
