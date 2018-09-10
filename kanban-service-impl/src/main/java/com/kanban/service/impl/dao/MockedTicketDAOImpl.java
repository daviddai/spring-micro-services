package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class MockedTicketDAOImpl implements TicketDAO {

    @Override
    public Collection<Ticket> findAll() {
        return MockedDatabase.getTickets();
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return MockedDatabase.getTickets()
                             .stream()
                             .filter(ticket -> ticket.getId() == id)
                             .findFirst();
    }
}
