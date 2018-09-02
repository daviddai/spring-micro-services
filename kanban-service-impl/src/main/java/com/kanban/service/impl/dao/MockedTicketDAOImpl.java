package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class MockedTicketDAOImpl implements TicketDAO {

    @Override
    public Collection<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();

        List<Task> tasks1 = new ArrayList<>();
        tasks1.add(createMockedTask(1L, "ContactList Example", true));
        tasks1.add(createMockedTask(2L, "Kanban Example", false));
        tasks1.add(createMockedTask(3L, "My Own Experiments", false));
        tickets.add(createMockedTicket(1l, "Write some code", "I should read the whole book", TicketStatus.READY, tasks1));



        return tickets;
    }

    private Task createMockedTask(Long id, String name, boolean done) {
        return new Task(id, name, done);
    }

    private Ticket createMockedTicket(Long id,
                                      String title,
                                      String description,
                                      TicketStatus status,
                                      Collection<Task> tasks) {

        return new Ticket(id, title, description, status, tasks);

    }
}
