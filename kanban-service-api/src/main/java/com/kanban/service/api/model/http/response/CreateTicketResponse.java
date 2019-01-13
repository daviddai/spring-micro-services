package com.kanban.service.api.model.http.response;

import com.kanban.service.api.model.TicketDTO;

public class CreateTicketResponse {

    private TicketDTO ticketDTO;

    public CreateTicketResponse(TicketDTO ticketDTO) {
        this.ticketDTO = ticketDTO;
    }

    public TicketDTO getTicketDTO() {
        return ticketDTO;
    }
}
