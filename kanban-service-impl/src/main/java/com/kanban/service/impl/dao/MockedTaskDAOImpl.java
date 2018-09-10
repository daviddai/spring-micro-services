package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class MockedTaskDAOImpl implements TaskDAO {

    @Override
    public Collection<Task> findAllByTicketId(long ticketId) {
        return null;
    }

    @Override
    public void update(long ticketId, Task newTask) {
        Collection<Ticket> tickets = MockedDatabase.getTickets();

        tickets.stream()
               .filter(ticket -> ticket.getId() == ticketId)
               .findFirst()
               .map(ticket -> ticket.getTasks().stream()
                                               .filter(task -> task.getId() == newTask.getId())
                                               .findFirst()
                                               .map(task -> {
                                                   task.setName(newTask.getName());
                                                   task.setDone(newTask.isDone());
                                                   return task;
                                               }));
    }
}
