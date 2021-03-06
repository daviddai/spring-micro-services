package com.kanban.service.api.controller;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.http.AddTaskResponse;
import com.kanban.service.api.model.http.Response;
import com.kanban.service.api.model.http.UpdateTaskNameRequest;
import com.kanban.service.api.model.http.UpdateTaskStatusRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/task")
public interface TaskController {

    @PostMapping
    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AddTaskResponse> addTask(@RequestBody TaskDTO taskDTO);

    @PostMapping
    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> update(@RequestBody TaskDTO taskDTO);

    @PostMapping
    @RequestMapping(value = "/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> updateStatus(@RequestBody UpdateTaskStatusRequest request);

    @PostMapping
    @RequestMapping(value = "/update/name", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> updateName(@RequestBody UpdateTaskNameRequest request);

    @PostMapping
    @RequestMapping(value = "/delete/{ticketId}/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> remove(@PathVariable("ticketId") long ticketId, @PathVariable("taskId") long taskId);

}
