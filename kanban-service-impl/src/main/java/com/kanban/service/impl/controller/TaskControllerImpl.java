package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TaskController;
import com.kanban.service.impl.manager.TaskManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskManager taskManager;

    @Override
    public ResponseEntity<String> toggleStatus(long ticketId, long taskId) {
        return null;
    }
}
