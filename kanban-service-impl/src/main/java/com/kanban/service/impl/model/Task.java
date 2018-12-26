package com.kanban.service.impl.model;

import java.io.Serializable;

public class Task implements Serializable {

    private long id;
    private String name;
    private boolean done;
    private long ticketId;

    public Task() {}

    public Task(long id, String name, boolean done, long ticketId) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.ticketId = ticketId;
    }

    // todo: find a better solution as ideally once task is created, the id should be IMMUTABLE
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }
}
