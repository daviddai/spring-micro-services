package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TicketController;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.manager.TicketManager;
import com.kanban.service.impl.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class TicketControllerImpl implements TicketController {

    @Autowired
    private TicketManager ticketManager;

    @Override
    public ResponseEntity<Collection<TicketDTO>> getAll() {
        Collection<Ticket> tickets = this.ticketManager.getAllTickets();

        if (tickets != null && !tickets.isEmpty()) {
            Collection<TicketDTO> ticketDTOs = tickets.stream()
                                                      .map(Ticket::toTicketDTO)
                                                      .collect(Collectors.toList());
            return ResponseEntity.ok(ticketDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
