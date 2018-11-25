package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.impl.model.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {

    Task taskDTO2Task(TaskDTO taskDTO);

    TaskDTO task2TaskDTO(Task task);

}
