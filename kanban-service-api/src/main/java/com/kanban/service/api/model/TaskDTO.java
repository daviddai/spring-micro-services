package com.kanban.service.api.model;

public class TaskDTO {

    private long id;
    private String name;
    private boolean done;

    public TaskDTO(long id, String name, boolean done) {
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String name;
        private boolean done;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder done(boolean done) {
            this.done = done;
            return this;
        }

        public TaskDTO build() {
            return new TaskDTO(
                this.id,
                this.name,
                this.done
            );
        }
    }
}
