package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TicketController;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.api.model.http.request.CreateTicketRequest;
import com.kanban.service.api.model.http.request.UpdateTicketStatusRequest;
import com.kanban.service.api.model.http.response.CreateTicketResponse;
import com.kanban.service.api.model.http.response.GetAllTicketsResponse;
import com.kanban.service.impl.facade.KanbanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping
    @RequestMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetAllTicketsResponse> getAll() {
        Collection<TicketDTO> ticketDTOs = this.kanbanFacade.getAllTickets();

        if (ticketDTOs != null && !ticketDTOs.isEmpty()) {
            GetAllTicketsResponse response = new GetAllTicketsResponse.Builder()
                                                                      .withTickets((new ArrayList<>(ticketDTOs)))
                                                                      .isSucceed(true)
                                                                      .build();
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @PostMapping
    @RequestMapping(path = "/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStatus(@RequestBody UpdateTicketStatusRequest request) {
        this.kanbanFacade.updateTicketStatus(request);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping
    @RequestMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody TicketDTO ticketDTO) {
        this.kanbanFacade.updateTicket(ticketDTO);
        return ResponseEntity.ok().build();
    }


}