package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class MockedTaskDAOImpl implements TaskDAO {

    @Override
    public Collection<Task> findAllByTicketId(long ticketId) {
        return null;
    }

    @Override
    public long add(Task task) {
        return -1;
    }

    @Override
    public void addBatch(List<Task> tasks) {

    }

    @Override
    public void update(Task newTask) {
        Collection<Ticket> tickets = MockedDatabase.getTickets();

        tickets.stream()
               .filter(ticket -> ticket.getId() == newTask.getTicketId())
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

    @Override
    public void updateStatus(long ticketId, long taskId, boolean done) {

    }

    @Override
    public void updateName(long ticketId, long taskId, String name) {
        
    }

    @Override
    public void delete(long ticketId, long taskId) {

    }
}
