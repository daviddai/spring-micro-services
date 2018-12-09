package com.kanban.service.impl.mapper;

import com.kanban.service.impl.model.TicketStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketStatusMapper {

    TicketStatusMapper INSTANCE = Mappers.getMapper(TicketStatusMapper.class);

    TicketStatus mapString(String status);

}
