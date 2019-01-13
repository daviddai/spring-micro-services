package com.kanban.service.api.model.http.response;

import com.kanban.service.api.model.TicketDTO;
import com.micro.service.common.model.http.Response;

import java.util.List;

public class GetAllTicketsResponse extends Response {

    private final static String TICKETS = "tickets";

    public static class Builder {

        private GetAllTicketsResponse response;

        public Builder() {
            this.response = new GetAllTicketsResponse();
        }

        public Builder isSucceed(boolean succeed) {
            this.response.succeed = succeed;
            return this;
        }

        public Builder withTickets(List<TicketDTO> tickets) {
            this.response.getData().put(TICKETS, tickets);
            return this;
        }

        public GetAllTicketsResponse build() {
            return this.response;
        }

    }

}
