package com.kanban.service.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

public class TicketDTO {

    private long id;
    private String title;
    private String description;
    private String status;
    private Collection<TaskDTO> taskDTOs;

    @JsonCreator
    public TicketDTO(
            @JsonProperty("id") long id,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("status") String status,
            @JsonProperty("tasks") Collection<TaskDTO> taskDTOs) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.taskDTOs = taskDTOs;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Collection<TaskDTO> getTaskDTOs() {
        return taskDTOs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private long id;
        private String title;
        private String description;
        private String status;
        Collection<TaskDTO> taskDTOs;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTaskDTOs(Collection<TaskDTO> taskDTOs) {
            this.taskDTOs = taskDTOs;
            return this;
        }

        public TicketDTO build() {
            return new TicketDTO(
                this.id,
                this.title,
                this.description,
                this.status,
                this.taskDTOs
            );
        }

    }
}
