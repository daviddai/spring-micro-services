package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.impl.model.Task;
import org.junit.Assert;
import org.junit.Test;

public class TaskMapperTest {

    @Test
    public void testMapTask() {
        Task task = new Task(1, "task", true, 1);
        TaskDTO taskDTO = TaskMapper.INSTANCE.mapTask(task);
        Assert.assertEquals(task.getId(), taskDTO.getId());
        Assert.assertEquals(task.getName(), taskDTO.getName());
        Assert.assertEquals(task.isDone(), taskDTO.isDone());
        Assert.assertEquals(task.getTicketId(), taskDTO.getTicketId());
    }

    @Test
    public void testMapTaskDTO() {
        TaskDTO taskDTO = new TaskDTO(1, "taskDTO", true, 1);
        Task task = TaskMapper.INSTANCE.mapTaskDTO(taskDTO);
        Assert.assertEquals("Task id should be " + taskDTO.getId(), taskDTO.getId(), task.getId());
        Assert.assertEquals("Task name should be " + taskDTO.getName(), taskDTO.getName(), task.getName());
        Assert.assertEquals("Task status should be " + taskDTO.isDone(), taskDTO.isDone(), task.isDone());
    }

}
