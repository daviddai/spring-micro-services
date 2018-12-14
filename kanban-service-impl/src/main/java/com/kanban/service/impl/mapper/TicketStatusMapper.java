package com.kanban.service.impl.mapper;

import com.kanban.service.impl.model.TicketStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class TicketStatusMapper {

    public static TicketStatusMapper INSTANCE = Mappers.getMapper(TicketStatusMapper.class);

    public TicketStatus mapString(String status) {
        return TicketStatus.getTicketStatus(status);
    }

    public String mapEnum(TicketStatus ticketStatus) {
        if (ticketStatus == null) {
            return null;
        } else {
            return ticketStatus.getDescription();
        }
    }

}
