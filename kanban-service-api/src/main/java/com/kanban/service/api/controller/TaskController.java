package com.kanban.service.api.controller;

import com.kanban.service.api.model.http.Response;
import com.kanban.service.api.model.http.UpdateTaskStatusRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public interface TaskController {

    @PostMapping
    @RequestMapping(value = "/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateStatus(@RequestBody UpdateTaskStatusRequest request);

}
