package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;

import java.util.Collection;

public interface TaskDAO {

    public long add(Task task);

    public Collection<Task> findAllByTicketId(long ticketId);

    public void update(Task task);

    public void updateStatus(long ticketId, long taskId, boolean done);

    public void remove(long ticketId, long taskId);

}
