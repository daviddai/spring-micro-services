package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TicketDAOImplTest {

    private TicketDAOImpl ticketDAOImpl;
    private Map<String, Object> row;

    @Before
    public void init() {
        ticketDAOImpl = new TicketDAOImpl();
        row = new HashMap<>();
        row.put("ticket_id", 1L);
        row.put("ticket_title", "ticket title");
        row.put("ticket_description", "ticket description");
        row.put("ticket_status", "todo");
        row.put("task_id", 2L);
        row.put("task_name", "task name");
        row.put("task_status", true);
    }

    @Test
    public void testMapRowToTicket() {
        Ticket ticket = ticketDAOImpl.mapRowToTicket(row);
        Assert.assertNotNull(ticket);
        Assert.assertEquals(1, ticket.getId());
        Assert.assertEquals("ticket title", ticket.getTitle());
        Assert.assertEquals("ticket description", ticket.getDescription());
        Assert.assertEquals(TicketStatus.TODO, ticket.getStatus());
        Assert.assertNotNull(ticket.getTasks());
    }

    @Test
    public void testMapRowToTask() {
        Task task = ticketDAOImpl.mapRowToTask(row);
        Assert.assertNotNull(task);
        Assert.assertEquals(2, task.getId());
        Assert.assertEquals("task name", task.getName());
        Assert.assertEquals(true, task.isDone());
    }

}
