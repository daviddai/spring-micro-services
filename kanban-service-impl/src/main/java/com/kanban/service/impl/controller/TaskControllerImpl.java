package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TaskController;
import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.http.Response;
import com.kanban.service.api.model.http.UpdateTaskStatusRequest;
import com.kanban.service.impl.facade.KanbanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/task")
public class TaskControllerImpl implements TaskController {

    @Autowired
    private KanbanFacade kanbanFacade;

    @Override
    @PostMapping
    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody TaskDTO taskDTO) {
        kanbanFacade.updateTask(taskDTO);
        return ResponseEntity.ok(new Response(true));
    }

    @Override
    @PostMapping
    @RequestMapping(value = "/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateStatus(@RequestBody UpdateTaskStatusRequest request) {
        kanbanFacade.updateTaskStatus(request);
        return ResponseEntity.ok(new Response(true));
    }
}
