package com.user.service.impl.model;

import com.kanban.service.api.model.TicketDTO;

import java.util.Collection;

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

    // TODO: need to finish taskdto in kanban service api
    public TicketDTO toTicketDTO(Ticket ticket) {
        return TicketDTO.builder()
                        .setId(this.id)
                        .setTitle(this.title)
                        .setDescription(this.description)
                        .setStatus(this.status.getDescription())
                        .build();
    }
}
