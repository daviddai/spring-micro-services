package com.kanban.service.api.model;

import java.util.Collection;

public class TicketDTO {

    private Long id;
    private String title;
    private String description;
    private String status;
    Collection<TaskDTO> taskDTOs;

    public TicketDTO(Long id, String title, String description, String status, Collection<TaskDTO> taskDTOs) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.taskDTOs = taskDTOs;
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

    public String getStatus() {
        return status;
    }

    public Collection<TaskDTO> getTaskDTOs() {
        return taskDTOs;
    }
}
