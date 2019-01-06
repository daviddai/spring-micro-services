package com.kanban.service.api.model.http;

public class UpdateTicketStatusRequest {

    private long ticketId;
    private String newTicketStatus;

    public UpdateTicketStatusRequest(long ticketId, String newTicketStatus) {
        this.ticketId = ticketId;
        this.newTicketStatus = newTicketStatus;
    }

    public long getTicketId() {
        return ticketId;
    }

    public String getNewTicketStatus() {
        return newTicketStatus;
    }
}
