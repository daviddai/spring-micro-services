package com.kanban.service.api.model;

public class TaskDTO {

    private Long id;
    private Long name;
    private boolean done;

    public TaskDTO(Long id, Long name, boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public Long getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }
}
