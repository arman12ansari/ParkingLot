package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mdarmanansari
 */
public class Ticket extends BaseModel {
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;

    @Override
    public String toString() {
        return "{" +
                "\nticketId=" + getId() +
                ",\nentryTime=" + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(entryTime) +
                ",\nvehicleNumber=" + vehicle.getVehicleNumber() +
                ",\nparkingSpot=" + parkingSpot.getNumber() +
                ",\nentryGate=" + entryGate.getGateNumber() +
                "\n}";
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }
}
