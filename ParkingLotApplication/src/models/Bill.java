package models;

import models.enums.BillStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mdarmanansari
 */
public class Bill extends BaseModel {
    private LocalDateTime exitTime;
    private double amount;
    private BillStatus status;
    private Ticket ticket;
    private Gate exitGate;

    @Override
    public String toString() {
        return "{" +
                "amount=" + amount +
                ",\nexitTime=" + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(exitTime) +
                ",\nstatus=" + status +
                ",\nticketId=" + ticket.getId() +
                ",\nexitGate=" + exitGate.getGateNumber() +
                "\n}";
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
