package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TicketController;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.api.model.http.CreateTicketRequest;
import com.kanban.service.api.model.http.CreateTicketResponse;
import com.kanban.service.impl.facade.KanbanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
public class TicketControllerImpl implements TicketController {

    @Autowired
    private KanbanFacade kanbanFacade;

    @Override
    @PostMapping
    @RequestMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateTicketResponse> create(@RequestBody CreateTicketRequest request) {
        CreateTicketResponse response = kanbanFacade.createNewTicket(request);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Collection<TicketDTO>> getAll() {
        Collection<TicketDTO> ticketDTOs = this.kanbanFacade.getAllTickets();

        if (ticketDTOs != null && !ticketDTOs.isEmpty()) {
            return ResponseEntity.ok(ticketDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity update(@RequestBody TicketDTO ticketDTO) {
        this.kanbanFacade.updateTicketStatus(ticketDTO);
        return ResponseEntity.ok().build();
    }


}