package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TaskMapper.class, TicketStatusMapper.class})
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(source = "taskDTOs", target = "tasks")
    Ticket mapTicketDTO(TicketDTO ticketDTO);

    @Mapping(source = "tasks", target = "taskDTOs")
    TicketDTO mapTicket(Ticket ticket);

}
