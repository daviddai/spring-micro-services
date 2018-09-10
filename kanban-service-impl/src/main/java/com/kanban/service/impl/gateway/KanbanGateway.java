package com.kanban.service.impl.gateway;

import com.kanban.service.impl.manager.TaskManager;
import com.kanban.service.impl.manager.TicketManager;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KanbanGateway {

    @Autowired
    private TicketManager ticketManager;

    @Autowired
    private TaskManager taskManager;

    public void toggleTaskStatus(long ticketId, long taskId) {
        Ticket ticket = ticketManager.findTicketById(ticketId);

        if (ticket != null) {
            Optional<Task> newTask = ticket.getTasks()
                                           .stream()
                                           .filter(task -> task.getId() == taskId)
                                           .findFirst();

            newTask.ifPresent(task -> task.setDone(!task.isDone()));

            this.taskManager.toggleTaskStatus(ticketId, newTask.get());
        }
    }

}
