package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MockedTicketDAOImpl implements TicketDAO {

    @Override
    public long add(Ticket ticket) {
        return -1;
    }

    @Override
    public List findAll() {
        return MockedDatabase.getTickets();
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return MockedDatabase.getTickets()
                             .stream()
                             .filter(ticket -> ticket.getId() == id)
                             .findFirst();
    }

    @Override
    public void update(Ticket newTicket) {
        MockedDatabase.getTickets()
                      .stream()
                      .filter(ticket -> ticket.getId() == newTicket.getId())
                      .findFirst()
                      .map(ticket -> {
                          ticket.setTitle(newTicket.getTitle());
                          ticket.setDescription(newTicket.getDescription());
                          ticket.setStatus(newTicket.getStatus());
                          return ticket;
                      });
    }

    @Override
    public void updateStatus(long ticketId, TicketStatus newTicketStatus) {

    }
}
