package com.kanban.service.impl.service;

import com.kanban.service.impl.dao.TicketDAO;
import com.kanban.service.impl.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TicketService {

    @Autowired
    private TicketDAO ticketDAO;


    public Collection<Ticket> getAllTickets() {
        return this.ticketDAO.findAll();
    }

    public Ticket findTicketById(long id) {
        return this.ticketDAO.findById(id).orElse(null);
    }

    public void updateTicket(Ticket ticket) {
        this.ticketDAO.update(ticket);
    }

}
