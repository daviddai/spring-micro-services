package com.kanban.service.impl.mapper;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketMapperTest {

    @Test
    public void testMapTicketDTO() {
        List<TaskDTO> taskDTOs = Collections.singletonList(
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
                                       .setTaskDTOs(taskDTOs)
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
        List<Task> tasks = Collections.singletonList(
                new Task(2, "name", false)
        );

        Ticket ticket = new Ticket(1, "title", "description", TicketStatus.FINISHED, tasks);

        TicketDTO ticketDTO = TicketMapper.INSTANCE.mapTicket(ticket);

        Assert.assertEquals("ticket dto id should be " + ticket.getId(), ticket.getId(), ticketDTO.getId());
        Assert.assertEquals("ticket dto title should be " + ticket.getTitle(), ticket.getTitle(), ticketDTO.getTitle());
        Assert.assertEquals("ticket dto description should be " + ticket.getDescription(), ticket.getDescription(), ticketDTO.getDescription());
        Assert.assertEquals("ticket dto status should be finished", ticket.getStatus().getDescription(), ticketDTO.getStatus());

        Assert.assertNotNull(ticketDTO.getTaskDTOs());
        Assert.assertEquals("task list length should be " + ticket.getTasks().size(), ticket.getTasks().size(), ticketDTO.getTaskDTOs().size());

        Task task = tasks.get(0);
        TaskDTO taskDTO = new ArrayList<>(ticketDTO.getTaskDTOs()).get(0);
        Assert.assertEquals("Task id should be " + taskDTO.getId(), taskDTO.getId(), task.getId());
        Assert.assertEquals("Task name should be " + taskDTO.getName(), taskDTO.getName(), task.getName());
        Assert.assertEquals("Task status should be " + taskDTO.isDone(), taskDTO.isDone(), task.isDone());
    }

}
