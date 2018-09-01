package com.kanban.service.impl.model;

public enum TicketStatus {

    READY("ready"),
    IN_PROGRESS("in_progress"),
    FINISHED("finished");

    private String description;

    TicketStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
