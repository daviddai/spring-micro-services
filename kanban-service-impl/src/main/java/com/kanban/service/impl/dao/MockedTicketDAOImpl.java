package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class MockedTicketDAOImpl implements TicketDAO {

    @Override
    public Collection<Ticket> findAll() {
        Collection<Ticket> tickets = new ArrayList<>();


        return tickets;
    }

    private Ticket createMockedTicket(Long id, String title, String description, TicketStatus status) {
        return new Ticket(id, title, description, status, null);
    }
}
