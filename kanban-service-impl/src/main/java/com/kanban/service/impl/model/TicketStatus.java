package com.kanban.service.impl.model;

public enum TicketStatus {

    READY("todo"),
    IN_PROGRESS("in-progress"),
    FINISHED("finished");

    private String description;

    TicketStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
