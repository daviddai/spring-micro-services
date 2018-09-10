package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;

import java.util.Collection;

public interface TaskDAO {

    public Collection<Task> findAllByTicketId(long ticketId);

    public void update(long ticketId, Task task);

}
