package repository;

import exception.TicketNotFoundException;
import models.Ticket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mdarmanansari
 */
public class TicketRepository {
    private Map<Integer, Ticket> ticketMap;
    private static int idCounter = 0;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId) {
        Ticket ticket = ticketMap.get(ticketId);

        if (ticket == null) {
            throw new TicketNotFoundException("Ticket not found with id: " + ticketId);
        }
        return ticket;
    }

    public Ticket put(Ticket ticket) {
        ticket.setId(++idCounter);
        ticketMap.put(ticket.getId(), ticket);
        System.out.println("Ticket has been added successfully");

        return ticketMap.get(ticket.getId());
    }
}
