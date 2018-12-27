package com.kanban.service.api.model.http;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddTaskResponse extends Response {

    private long taskId;

    @JsonCreator
    public AddTaskResponse(@JsonProperty("succeed") boolean succeed,
                           @JsonProperty("message") String message,
                           @JsonProperty("taskId") long taskId) {
        super(succeed, message);
        this.taskId = taskId;
    }

    public long getTaskId() {
        return taskId;
    }
}
