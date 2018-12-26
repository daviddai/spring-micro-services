package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MockedDatabase {

    private static List<Ticket> tickets = new ArrayList<>();

    public static List<Ticket> getTickets() {
        if (!tickets.isEmpty()) {
            return tickets;
        }

        List<Task> tasks = new ArrayList<>();
        tasks.add(createMockedTask(1L, "ContactList Example", true, 1));
        tasks.add(createMockedTask(2L, "Kanban Example", false, 1));
        tasks.add(createMockedTask(3L, "My Own Experiments", false, 1));
        tickets.add(createMockedTicket(1L, "Write some code", "Code along with the samples in the book. The complete source can be found at [github](https://github.com/pro-react)", TicketStatus.TODO, tasks));
        tickets.add(createMockedTicket(2L, "Read the book", "I should read the whole book", TicketStatus.IN_PROGRESS, Collections.emptyList()));
        return tickets;
    }

    private static Task createMockedTask(long id, String name, boolean done, long ticketId) {
        return new Task(id, name, done, ticketId);
    }

    private static Ticket createMockedTicket(Long id,
                                      String title,
                                      String description,
                                      TicketStatus status,
                                      Collection<Task> tasks) {
        return new Ticket(id, title, description, status, tasks);
    }

}
