package com.kanban.service.impl.manager;

import com.kanban.service.impl.dao.TaskDAO;
import com.kanban.service.impl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskManager {

    @Autowired
    private TaskDAO taskDAO;

    public void toggleTaskStatus(long ticketId, Task task) {
        this.taskDAO.update(ticketId, task);
    }

}
