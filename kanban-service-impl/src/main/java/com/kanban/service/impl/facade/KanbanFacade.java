package com.kanban.service.impl.facade;

import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.service.TaskService;
import com.kanban.service.impl.service.TicketService;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KanbanFacade {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TaskService taskService;

    public Collection<TicketDTO> getAllTickets() {
        Collection<Ticket> tickets = this.ticketService.getAllTickets();

        if (tickets != null && !tickets.isEmpty()) {
            return tickets.stream()
                          .map(Ticket::toTicketDTO)
                          .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public void toggleTaskStatus(long ticketId, long taskId) {
        Ticket ticket = ticketService.findTicketById(ticketId);

        if (ticket != null) {
            Optional<Task> newTask = ticket.getTasks()
                                           .stream()
                                           .filter(task -> task.getId() == taskId)
                                           .findFirst();

            newTask.ifPresent(task -> task.setDone(!task.isDone()));

            this.taskService.toggleTaskStatus(ticketId, newTask.get());
        }
    }

    public void updateTicketStatus(TicketDTO ticketDTO) {
        this.ticketService.updateTicket(this.fromTicketDTO(ticketDTO));
    }

    private Ticket fromTicketDTO(TicketDTO ticketDTO) {
        return new Ticket(
            ticketDTO.getId(),
            ticketDTO.getTitle(),
            ticketDTO.getDescription(),
            TicketStatus.getTicketStatus(ticketDTO.getStatus()),
            null
        );
    }

}
