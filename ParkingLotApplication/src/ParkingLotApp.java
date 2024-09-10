import controller.BillController;
import controller.InitController;
import controller.PaymentController;
import controller.TicketController;
import exception.InvalidVehicleTypeException;
import models.*;
import models.enums.VehicleType;
import repository.*;
import service.BillService;
import service.InitialisationService;
import service.PaymentService;
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
        PaymentRepository paymentRepository = new PaymentRepository();

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

        BillService billService = new BillService(
                billRepository,
                parkingLotRepository,
                parkingSpotRepository,
                ticketRepository,
                gateRepository
        );

        PaymentService paymentService = new PaymentService(
                paymentRepository,
                billRepository
        );

        TicketController ticketController = new TicketController(ticketService);
        InitController initController = new InitController(initialisationService);
        BillController billController = new BillController(billService);
        PaymentController paymentController = new PaymentController(paymentService);

        System.out.println("*** PARKING LOT DATA INITIALISATION - START ***");
        ParkingLot parkingLot = initController.init();
        System.out.println("*** PARKING LOT DATA INITIALISATION - END ***");

        while (true) {
            System.out.println("Please enter an option: \n 1. Enter Parking Lot \n 2. Exit Parking Lot \n 3. Exit");
            System.out.println("Enter your option : ");
            int option = sc.nextInt();

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
                } else {
                    throw new InvalidVehicleTypeException("Please Enter a valid vehicle type");
                }

                System.out.println("Please enter the parkingLot ID");
                int parkingLotId = sc.nextInt();

                Ticket ticket = ticketController.generateTicket(vehicle, parkingLotId);
                System.out.println("Ticket details :" + ticket);

            } else if (option == 2) {
                System.out.println("Please enter the Ticket ID");
                int ticketId = sc.nextInt();
                Bill bill = billController.generateBill(ticketId);

                System.out.println("Bill details :" + bill);

                System.out.println("How you want to Pay Bill \n 1. Cash \n 2. Card \n 3. UPI");
                int paymentOption = sc.nextInt();

                Payment payment = paymentController.makePayment(paymentOption, bill);

                System.out.println("Payment details :" + payment);

            } else {
                System.out.println("Thanks for Visiting " + parkingLot.getName());
                break;
            }
        }
    }
}