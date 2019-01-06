package com.kanban.service.impl.service;

import com.kanban.service.impl.dao.TicketDAO;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TicketService {

    @Autowired
    @Qualifier("jdbcTicketDAO")
    private TicketDAO ticketDAO;

    public long createTicket(Ticket ticket) {
        return this.ticketDAO.add(ticket);
    }

    public Collection<Ticket> getAllTickets() {
        return this.ticketDAO.findAll();
    }

    public Ticket findTicketById(long id) {
        return this.ticketDAO.findById(id).orElse(null);
    }

    public void updateTicketStatus(long ticketId, TicketStatus ticketStatus) {
        this.ticketDAO.updateStatus(ticketId, ticketStatus);
    }

    public void updateTicket(Ticket ticket) {
        this.ticketDAO.update(ticket);
    }

}
