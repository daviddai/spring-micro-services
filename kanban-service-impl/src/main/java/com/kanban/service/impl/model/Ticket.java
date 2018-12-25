package com.kanban.service.impl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Ticket implements Serializable {

    private long id;
    private String title;
    private String description;
    private TicketStatus status;
    private Collection<Task> tasks;

    public Ticket() {
        this.tasks = new ArrayList<>();
    }

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

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }
}
