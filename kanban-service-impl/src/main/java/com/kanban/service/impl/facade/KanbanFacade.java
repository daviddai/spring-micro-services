package com.kanban.service.impl.facade;

import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.api.model.http.UpdateTaskStatusRequest;
import com.kanban.service.impl.mapper.TicketMapper;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import com.kanban.service.impl.service.TaskService;
import com.kanban.service.impl.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
                          .map(TicketMapper.INSTANCE::mapTicket)
                          .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public void updateTaskStatus(UpdateTaskStatusRequest request) {
        if (request != null) {
            taskService.updateTaskStatus(request.getTicketId(), request.getTaskId(), request.isDone());
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
