package com.kanban.service.api.model.http;

public class UpdateTaskStatusRequest {

    private long ticketId;
    private long taskId;
    private boolean done;

    public long getTicketId() {
        return ticketId;
    }

    public long getTaskId() {
        return taskId;
    }

    public boolean isDone() {
        return done;
    }
}
