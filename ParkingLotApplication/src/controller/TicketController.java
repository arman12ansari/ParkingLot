package controller;

import exception.InvalidRequestException;
import models.Ticket;
import models.Vehicle;
import service.TicketService;

/**
 * @author mdarmanansari
 */
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public Ticket generateTicket(Vehicle vehicle, int parkingLotId) {
        if (parkingLotId <= 0) {
            throw new InvalidRequestException("Please enter valid request");
        }

        return ticketService.generateTicket(vehicle, parkingLotId);
    }
}
