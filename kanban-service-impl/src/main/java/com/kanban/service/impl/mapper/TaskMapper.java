package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.impl.model.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task mapTaskDTO(TaskDTO taskDTO);

    TaskDTO mapTask(Task task);

}
