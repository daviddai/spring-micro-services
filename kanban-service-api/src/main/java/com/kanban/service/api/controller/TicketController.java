package com.kanban.service.api.controller;

import com.kanban.service.api.model.TicketDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
public interface TicketController {

    @GetMapping
    @RequestMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TicketDTO>> getAll();

}
