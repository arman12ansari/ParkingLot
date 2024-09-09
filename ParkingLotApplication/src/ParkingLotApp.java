import controller.InitController;
import controller.TicketController;
import models.ParkingLot;
import models.Ticket;
import models.Vehicle;
import models.enums.VehicleType;
import repository.*;
import service.InitialisationService;
import service.TicketService;

import java.util.Scanner;

/**
 * @author mdarmanansari
 */
public class ParkingLotApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        BillRepository billRepository = new BillRepository();

        InitialisationService initialisationService = new InitialisationService(
                gateRepository,
                parkingLotRepository,
                parkingFloorRepository,
                parkingSpotRepository
        );

        TicketService ticketService = new TicketService(
                ticketRepository,
                parkingLotRepository,
                gateRepository,
                parkingSpotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        InitController initController = new InitController(initialisationService);

        System.out.println("*** PARKING LOT DATA INITIALISATION - START ***");
        ParkingLot parkingLot = initController.init();
        System.out.println("*** PARKING LOT DATA INITIALISATION - END ***");

        System.out.println("Please enter an option: \n 1. Enter Parking Lot \n 2. Exit Parking Lot \n 3. Exit");
        System.out.println("Enter your option : ");
        int option = sc.nextInt();

        while (true) {
            if (option == 1) {
                Vehicle vehicle = new Vehicle();
                System.out.println("Welcome to our parking lot");
                System.out.println("Please enter the vehicle details");

                System.out.println("Please enter the vehicle number : ");
                String number = sc.next();
                vehicle.setVehicleNumber(number);

                System.out.println("Please enter the vehicle color : ");
                String color = sc.next();
                vehicle.setColor(color);

                System.out.println("Please choose the vehicle type -> 1. Car and 2. Bike 3. EV 4. Luxury");
                int vehicleType = sc.nextInt();

                if (vehicleType == 1) {
                    vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
                } else if (vehicleType == 2) {
                    vehicle.setVehicleType(VehicleType.TWO_WHEELER);
                } else if (vehicleType == 3) {
                    vehicle.setVehicleType(VehicleType.EV);
                } else if (vehicleType == 4) {
                    vehicle.setVehicleType(VehicleType.LUXURY);
                }

                System.out.println("Please enter the parkingLot ID");
                int parkingLotId = sc.nextInt();

                Ticket ticket = ticketController.generateTicket(vehicle, parkingLotId);
                System.out.println("Ticket details :" + ticket);

            } else if (option == 2) {
                // Bill Implementation
            } else {
                System.out.println("THANKS");
                break;
            }
        }
    }
}