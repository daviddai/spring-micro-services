package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;

import java.util.Collection;
import java.util.List;

public interface TaskDAO {

    long add(Task task);

    void addBatch(List<Task> tasks);

    Collection<Task> findAllByTicketId(long ticketId);

    void update(Task task);

    void updateStatus(long ticketId, long taskId, boolean done);

    void updateName(long ticketId, long taskId, String name);

    void delete(long ticketId, long taskId);

}
