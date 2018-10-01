package com.kanban.service.api.controller;

import com.kanban.service.api.model.TicketDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/ticket")
public interface TicketController {

    @GetMapping
    @RequestMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Collection<TicketDTO>> getAll();

    @PostMapping
    @RequestMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity update(@RequestBody TicketDTO ticketDTO);

}
