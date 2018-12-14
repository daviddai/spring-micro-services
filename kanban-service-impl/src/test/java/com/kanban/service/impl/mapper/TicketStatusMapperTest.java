package com.kanban.service.impl.mapper;

import com.kanban.service.impl.model.TicketStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicketStatusMapperTest {

    private TicketStatusMapper ticketStatusMapper;

    @Before
    public void init() {
        ticketStatusMapper = TicketStatusMapper.INSTANCE;
    }

    @Test
    public void testMapString() {
        String[] srcStatuses = {"todo", "in-progress", "finished"};
        TicketStatus[] expectedTargetStatuses = {TicketStatus.TODO, TicketStatus.IN_PROGRESS, TicketStatus.FINISHED};

        for (int i = 0; i < srcStatuses.length; ++i) {
            Assert.assertEquals(expectedTargetStatuses[i], ticketStatusMapper.mapString(srcStatuses[i]));
        }
    }

    @Test
    public void testMapEnum() {
        TicketStatus[] srcStatuses = {TicketStatus.TODO, TicketStatus.IN_PROGRESS, TicketStatus.FINISHED};
        String[] expectedTargetStatuses = {"todo", "in-progress", "finished"};

        for (int i = 0; i < srcStatuses.length; ++i) {
            Assert.assertEquals(expectedTargetStatuses[i], ticketStatusMapper.mapEnum(srcStatuses[i]));
        }

    }

}
