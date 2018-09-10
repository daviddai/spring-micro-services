package com.kanban.service.api.controller;

import com.kanban.service.api.model.http.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public interface TaskController {

    @PostMapping
    @RequestMapping(value = "/toggle/{ticketId}/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> toggleStatus(@PathVariable("ticketId") long ticketId, @PathVariable("taskId") long taskId);

}
