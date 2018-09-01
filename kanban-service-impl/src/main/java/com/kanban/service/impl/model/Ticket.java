package com.kanban.service.impl.model;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.TicketDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class Ticket {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private Collection<Task> tasks;

    public Ticket(Long id, String title, String description, TicketStatus status, Collection<Task> tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public TicketDTO toTicketDTO() {
        Collection<TaskDTO> taskDTOs = this.tasks.stream()
                                                 .map(Task::toTaskDTO)
                                                 .collect(Collectors.toList());

        return TicketDTO.builder()
                        .setId(this.id)
                        .setTitle(this.title)
                        .setDescription(this.description)
                        .setTaskDtos(taskDTOs)
                        .setStatus(this.status.getDescription())
                        .build();
    }
}
