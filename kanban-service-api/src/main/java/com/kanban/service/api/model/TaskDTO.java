package com.kanban.service.api.model;

public class TaskDTO {

    private long id;
    private String name;
    private boolean done;
    private long ticketId;

    public TaskDTO(long id, String name, boolean done, long ticketId) {
        this.id = id;
        this.name = name;
        this.done = done;
        this.ticketId = ticketId;
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

    public long getTicketId() {
        return ticketId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String name;
        private boolean done;
        private long ticketId;


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

        public Builder setTicketId(long ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public TaskDTO build() {
            return new TaskDTO(
                this.id,
                this.name,
                this.done,
                this.ticketId
            );
        }
    }
}
