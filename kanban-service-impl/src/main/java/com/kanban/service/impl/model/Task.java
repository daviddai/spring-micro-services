package com.kanban.service.impl.model;

import com.kanban.service.api.model.TaskDTO;

public class Task {

    private long id;
    private String name;
    private boolean done;

    public Task() {}

    public Task(long id, String name, boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
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

    // todo: this method will be removed before this branch is merged
    @Deprecated
    public TaskDTO toTaskDTO() {
        return null;
    }
}
