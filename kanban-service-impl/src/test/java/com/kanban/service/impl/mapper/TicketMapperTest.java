package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketMapperTest {

    @Test
    public void testMapTicketDTO() {
        List<TaskDTO> taskDTOs = Arrays.asList(
                TaskDTO.builder()
                       .setId(2)
                       .setName("Task")
                       .done(true)
                       .build()
        );

        TicketDTO ticketDTO = TicketDTO.builder()
                                       .setId(1)
                                       .setDescription("Ticket Description")
                                       .setStatus("todo")
                                       .setTaskDtos(taskDTOs)
                                       .build();

        Ticket ticket = TicketMapper.INSTANCE.mapTicketDTO(ticketDTO);

        Assert.assertEquals("ticket id should be " + ticketDTO.getId(), ticketDTO.getId(), ticket.getId());
        Assert.assertEquals("ticket description should be " + ticketDTO.getDescription(), ticketDTO.getDescription(), ticket.getDescription());
        Assert.assertEquals("ticket status should be " + ticketDTO.getStatus(), ticket.getStatus(), ticket.getStatus());

        Assert.assertNotNull("task list should not be null", ticket.getTasks());
        Assert.assertEquals("task list length should be " + ticketDTO.getTaskDTOs().size(), ticketDTO.getTaskDTOs().size(), ticket.getTasks().size());

        Task task = new ArrayList<>(ticket.getTasks()).get(0);
        TaskDTO taskDTO = taskDTOs.get(0);
        Assert.assertEquals("Task id should be " + taskDTO.getId(), taskDTO.getId(), task.getId());
        Assert.assertEquals("Task name should be " + taskDTO.getName(), taskDTO.getName(), task.getName());
        Assert.assertEquals("Task status should be " + taskDTO.isDone(), taskDTO.isDone(), task.isDone());
    }

    @Test
    public void testMapTicket() {

    }

}
