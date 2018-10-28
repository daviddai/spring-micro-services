package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TicketController;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.gateway.KanbanGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin
public class TicketControllerImpl implements TicketController {

    @Autowired
    private KanbanGateway kanbanGateway;

    @Override
    public ResponseEntity<Collection<TicketDTO>> getAll() {
        Collection<TicketDTO> ticketDTOs = this.kanbanGateway.getAllTickets();

        if (ticketDTOs != null && !ticketDTOs.isEmpty()) {
            return ResponseEntity.ok(ticketDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity update(@RequestBody TicketDTO ticketDTO) {
        this.kanbanGateway.updateTicketStatus(ticketDTO);
        return ResponseEntity.ok().build();
    }


}