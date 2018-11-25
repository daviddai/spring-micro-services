package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TaskController;
import com.kanban.service.api.model.http.Response;
import com.kanban.service.impl.facade.KanbanFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskControllerImpl implements TaskController {

    @Autowired
    private KanbanFacade kanbanFacade;

    @Override
    public ResponseEntity<Response> toggleStatus(long ticketId, long taskId) {
        kanbanFacade.toggleTaskStatus(ticketId, taskId);
        return ResponseEntity.ok(new Response(true));
    }
}
