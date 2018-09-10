package com.kanban.service.impl.model;

import com.kanban.service.api.model.TaskDTO;

public class Task {

    private long id;
    private String name;
    private boolean done;

    public Task(long id, String name, boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
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

    public TaskDTO toTaskDTO() {
        return TaskDTO.builder()
                      .setId(this.id)
                      .setName(this.name)
                      .done(this.done)
                      .build();
    }
}
