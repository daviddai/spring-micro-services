package com.kanban.service.impl.manager;

import com.kanban.service.impl.dao.TicketDAO;
import com.kanban.service.impl.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TicketManager {

    @Autowired
    private TicketDAO ticketDAO;


    public Collection<Ticket> getAllTickets() {
        return this.ticketDAO.findAll();
    }

}
