package com.kanban.service.api.model.http;

import java.util.List;

public class CreateTicketRequest {

    private String ticketTitle;
    private String ticketDescription;
    private String ticketStatus;
    private List<String> taskNames;

    public CreateTicketRequest(String ticketTitle, String ticketDescription, String ticketStatus, List<String> taskNames) {
        this.ticketTitle = ticketTitle;
        this.ticketDescription = ticketDescription;
        this.ticketStatus = ticketStatus;
        this.taskNames = taskNames;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public List<String> getTaskNames() {
        return taskNames;
    }
}
