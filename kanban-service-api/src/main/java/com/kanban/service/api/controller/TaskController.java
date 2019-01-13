package com.kanban.service.api.controller;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.http.request.UpdateTaskNameRequest;
import com.kanban.service.api.model.http.request.UpdateTaskStatusRequest;
import com.kanban.service.api.model.http.response.AddTaskResponse;
import com.micro.service.common.model.http.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
