package com.kanban.service.api.model.http.request;

public class UpdateTaskNameRequest {

    private long ticketId;
    private long taskId;
    private String taskName;

    public UpdateTaskNameRequest(long ticketId, long taskId, String taskName) {
        this.ticketId = ticketId;
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public long getTicketId() {
        return ticketId;
    }

    public long getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }
}
