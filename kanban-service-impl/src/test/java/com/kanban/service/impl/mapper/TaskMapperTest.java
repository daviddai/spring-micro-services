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

    }

}
