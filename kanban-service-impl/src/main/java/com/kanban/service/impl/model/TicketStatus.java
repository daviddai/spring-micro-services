package com.kanban.service.impl.model;

import java.util.HashMap;
import java.util.Map;

public enum TicketStatus {

    READY("todo"),
    IN_PROGRESS("in-progress"),
    FINISHED("finished");

    private static final Map<String, TicketStatus> lookup = new HashMap<>();

    static {
        for (TicketStatus ticketStatus: TicketStatus.values()) {
            lookup.put(ticketStatus.getDescription(), ticketStatus);
        }
    }

    private String description;

    TicketStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static TicketStatus getTicketStatus(String description) {
        return lookup.get(description);
    }

}
