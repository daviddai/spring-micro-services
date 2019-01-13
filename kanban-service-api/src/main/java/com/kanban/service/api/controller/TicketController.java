package com.kanban.service.api.controller;

import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.api.model.http.request.CreateTicketRequest;
import com.kanban.service.api.model.http.request.UpdateTicketStatusRequest;
import com.kanban.service.api.model.http.response.CreateTicketResponse;
import com.kanban.service.api.model.http.response.GetAllTicketsResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ticket")
public interface TicketController {

    @PostMapping
    @RequestMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreateTicketResponse> create(@RequestBody CreateTicketRequest request);

    @GetMapping
    @RequestMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GetAllTicketsResponse> getAll();

    @PostMapping
    @RequestMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity update(@RequestBody TicketDTO ticketDTO);

    @PostMapping
    @RequestMapping(path = "/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity updateStatus(@RequestBody UpdateTicketStatusRequest request);

}
