package models;

import models.enums.PaymentMode;
import models.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mdarmanansari
 */
public class Payment extends BaseModel {
    private double amount;
    private String transactionRefNumber;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    private Bill bill;
    private LocalDateTime paymentTime;

    @Override
    public String toString() {
        return "{" +
                "amount=" + amount +
                ",\ntransactionRefNumber=" + transactionRefNumber +
                ",\npaymentStatus=" + paymentStatus +
                ",\npaymentMode=" + paymentMode +
                ",\nbillId=" + bill.getId() +
                ",\npaymentTime=" + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(paymentTime) +
                "\n}";
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionRefNumber() {
        return transactionRefNumber;
    }

    public void setTransactionRefNumber(String transactionRefNumber) {
        this.transactionRefNumber = transactionRefNumber;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
