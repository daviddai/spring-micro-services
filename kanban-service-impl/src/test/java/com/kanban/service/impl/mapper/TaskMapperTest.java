package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.impl.model.Task;
import org.junit.Assert;
import org.junit.Test;

public class TaskMapperTest {

    @Test
    public void testMappingFromTaskToTaskDTO() {
        Task task = new Task(1, "task", true);
        TaskDTO taskDTO = TaskMapper.INSTANCE.mapTask(task);
        Assert.assertEquals(task.getId(), taskDTO.getId());
        Assert.assertEquals(task.getName(), taskDTO.getName());
        Assert.assertEquals(task.isDone(), taskDTO.isDone());
    }

    @Test
    public void testMappingFromTaskDTOtoTask() {
        TaskDTO taskDTO = new TaskDTO(1, "taskDTO", true);
        Task task = TaskMapper.INSTANCE.mapTaskDTO(taskDTO);
        Assert.assertEquals(taskDTO.getId(), task.getId());
        Assert.assertEquals(taskDTO.getName(), task.getName());
        Assert.assertEquals(taskDTO.isDone(), task.isDone());
    }

}
