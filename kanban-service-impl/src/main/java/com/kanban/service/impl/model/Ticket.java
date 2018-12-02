package com.kanban.service.impl.model;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.TicketDTO;

import java.util.Collection;
import java.util.stream.Collectors;

public class Ticket {

    private long id;
    private String title;
    private String description;
    private TicketStatus status;
    private Collection<Task> tasks;

    public Ticket(long id, String title, String description, TicketStatus status, Collection<Task> tasks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.tasks = tasks;
    }

    public long getId() {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    // todo: this method will be removed before this branch is merged
    @Deprecated
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
