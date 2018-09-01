package com.kanban.service.api.model;

public class TaskDTO {

    private Long id;
    private String name;
    private boolean done;

    public TaskDTO(Long id, String name, boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public Long getId() {
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
        private Long id;
        private String name;
        private boolean done;

        public Builder setId(Long id) {
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
