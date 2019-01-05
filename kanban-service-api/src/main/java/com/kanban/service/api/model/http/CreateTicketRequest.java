package com.kanban.service.api.model.http;

import java.util.List;

public class CreateTicketRequest {

    private String ticketTitle;
    private String ticketDescription;
    private List<String> taskNames;

    public CreateTicketRequest(String ticketTitle, String ticketDescription, List<String> taskNames) {
        this.ticketTitle = ticketTitle;
        this.ticketDescription = ticketDescription;
        this.taskNames = taskNames;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public List<String> getTaskNames() {
        return taskNames;
    }
}
