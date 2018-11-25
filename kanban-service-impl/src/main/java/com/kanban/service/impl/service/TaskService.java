package com.kanban.service.impl.service;

import com.kanban.service.impl.dao.TaskDAO;
import com.kanban.service.impl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDAO taskDAO;

    public void toggleTaskStatus(long ticketId, Task task) {
        this.taskDAO.update(ticketId, task);
    }

}
