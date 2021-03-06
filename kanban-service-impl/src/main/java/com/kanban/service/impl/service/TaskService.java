package com.kanban.service.impl.service;

import com.kanban.service.impl.dao.TaskDAO;
import com.kanban.service.impl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    @Qualifier("jdbcTaskDAO")
    private TaskDAO taskDAO;

    public long addTask(Task task) {
        return taskDAO.add(task);
    }

    public void addTasks(List<Task> tasks) {
        this.taskDAO.addBatch(tasks);
    }

    public void updateTask(Task task) {
        if (task != null) {
            taskDAO.update(task);
        }
    }

    public void updateTaskStatus(long ticketId, long taskId, boolean done) {
        this.taskDAO.updateStatus(ticketId, taskId, done);
    }

    public void updateTaskName(long ticketId, long taskId, String name) {
        this.taskDAO.updateName(ticketId, taskId, name);
    }

    public void removeTask(long ticketId, long taskId) {
        taskDAO.delete(ticketId, taskId);
    }

}
