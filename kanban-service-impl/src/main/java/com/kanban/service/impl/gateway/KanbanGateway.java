package com.kanban.service.impl.gateway;

import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.manager.TaskManager;
import com.kanban.service.impl.manager.TicketManager;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KanbanGateway {

    @Autowired
    private TicketManager ticketManager;

    @Autowired
    private TaskManager taskManager;

    public Collection<TicketDTO> getAllTickets() {
        Collection<Ticket> tickets = this.ticketManager.getAllTickets();

        if (tickets != null && !tickets.isEmpty()) {
            return tickets.stream()
                          .map(Ticket::toTicketDTO)
                          .collect(Collectors.toList());
        } else {
            return null;
        }
    }

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

    public void updateTicketStatus(TicketDTO ticketDTO) {
        this.ticketManager.updateTicket(this.fromTicketDTO(ticketDTO));
    }

    private Ticket fromTicketDTO(TicketDTO ticketDTO) {
        return new Ticket(
            ticketDTO.getId(),
            ticketDTO.getTitle(),
            ticketDTO.getDescription(),
            TicketStatus.valueOf(ticketDTO.getStatus()),
            null
        );
    }

}
