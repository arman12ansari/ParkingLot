package service;

import models.Bill;
import models.Payment;
import models.enums.BillStatus;
import models.enums.PaymentMode;
import models.enums.PaymentStatus;
import repository.BillRepository;
import repository.PaymentRepository;

import java.time.LocalDateTime;

/**
 * @author mdarmanansari
 */
public class PaymentService {
    private PaymentRepository paymentRepository;
    private BillRepository billRepository;

    public PaymentService(PaymentRepository paymentRepository, BillRepository billRepository) {
        this.paymentRepository = paymentRepository;
        this.billRepository = billRepository;
    }

    public Payment makePayment(int paymentOption, Bill bill) {
        Payment payment = new Payment();

        payment.setAmount(bill.getAmount());
        payment.setTransactionRefNumber("TRN" + bill.getId());
        payment.setPaymentStatus(PaymentStatus.PAYMENT_SUCCESSFUL);

        if(paymentOption == 1) {
            payment.setPaymentMode(PaymentMode.CASH);
        } else if(paymentOption == 2) {
            payment.setPaymentMode(PaymentMode.CARD);
        } else if(paymentOption == 3) {
            payment.setPaymentMode(PaymentMode.UPI);
        }

        payment.setPaymentTime(LocalDateTime.now());

        bill.setStatus(BillStatus.PAID);

        payment.setBill(bill);

        billRepository.updateBill(bill);

        return paymentRepository.put(payment);
    }
}
