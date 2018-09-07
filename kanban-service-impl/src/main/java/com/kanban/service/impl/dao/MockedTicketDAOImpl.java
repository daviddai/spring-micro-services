package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MockedTicketDAOImpl implements TicketDAO {

    @Override
    public Collection<Ticket> findAll() {
        return MockedDatabase.getTickets();
    }

}
