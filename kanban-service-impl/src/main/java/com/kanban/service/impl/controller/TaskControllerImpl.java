package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TaskController;
import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.http.AddTaskResponse;
import com.kanban.service.api.model.http.UpdateTaskNameRequest;
import com.kanban.service.api.model.http.UpdateTaskStatusRequest;
import com.kanban.service.impl.facade.KanbanFacade;
import com.micro.service.common.model.http.Response;
import org.apache.commons.lang3.StringUtils;
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
    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddTaskResponse> addTask(@RequestBody TaskDTO taskDTO) {
        AddTaskResponse addTaskResponse;

        if (taskDTO != null) {
            if (StringUtils.isNotBlank(taskDTO.getName())) {
                long taskId = kanbanFacade.createNewTask(taskDTO);

                if (taskId != -1) {
                    addTaskResponse = new AddTaskResponse.Builder()
                                                         .isSucceed(true)
                                                         .withTaskId(taskId)
                                                         .build();
                    return ResponseEntity.ok(addTaskResponse);
                }
            }
        }

        addTaskResponse = new AddTaskResponse.Builder()
                                             .isSucceed(false)
                                             .withMessage("Invalid task dto")
                                             .build();
        return ResponseEntity.badRequest().body(addTaskResponse);
    }

    @Override
    @PostMapping
    @RequestMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody TaskDTO taskDTO) {
        if (taskDTO != null) {
            kanbanFacade.updateTask(taskDTO);
            return ResponseEntity.ok(new Response(true, null, null));
        }

        return ResponseEntity.badRequest().body(new Response(false, "Invalid task dto", null));
    }

    @Override
    @PostMapping
    @RequestMapping(value = "/update/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateStatus(@RequestBody UpdateTaskStatusRequest request) {
        if (request != null) {
            kanbanFacade.updateTaskStatus(request);
            return ResponseEntity.ok(new Response(true, null, null));
        }

        return ResponseEntity.badRequest().body(new Response(false, "Invalid task status update request", null));
    }

    @Override
    @RequestMapping(value = "/update/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateName(@RequestBody UpdateTaskNameRequest request) {
        if (request != null) {
            kanbanFacade.updateTaskName(request);
            return ResponseEntity.ok(new Response(true, null, null));
        }

        return ResponseEntity.badRequest().body(new Response(false, "Invalid task name update request", null));
    }

    @Override
    @RequestMapping(value = "/delete/{ticketId}/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> remove(@PathVariable("ticketId") long ticketId, @PathVariable("taskId") long taskId) {
        kanbanFacade.removeTaskFromTicket(ticketId, taskId);
        return ResponseEntity.ok(new Response(true, null, null));
    }
}
