package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket ticketDTO2Ticket(TicketDTO ticketDTO);

    @Mappings({
            @Mapping(target = "id", source = "ticket.id"),
            @Mapping(target = "title", source = "ticket.title"),
            @Mapping(target = "description", source = "ticket.status")
    })
    TicketDTO ticket2TicketDTO(Ticket ticket);

}
