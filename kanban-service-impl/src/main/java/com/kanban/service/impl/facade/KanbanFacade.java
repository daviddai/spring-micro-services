package com.kanban.service.impl.facade;

import com.kanban.service.api.model.TaskDTO;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.api.model.http.CreateTicketRequest;
import com.kanban.service.api.model.http.CreateTicketResponse;
import com.kanban.service.api.model.http.UpdateTaskNameRequest;
import com.kanban.service.api.model.http.UpdateTaskStatusRequest;
import com.kanban.service.impl.mapper.TaskMapper;
import com.kanban.service.impl.mapper.TicketMapper;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import com.kanban.service.impl.service.TaskService;
import com.kanban.service.impl.service.TicketService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KanbanFacade {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TaskService taskService;

    public Collection<TicketDTO> getAllTickets() {
        Collection<Ticket> tickets = this.ticketService.getAllTickets();

        if (tickets != null && !tickets.isEmpty()) {
            return tickets.stream()
                          .map(TicketMapper.INSTANCE::mapTicket)
                          .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    // todo: add transaction between adding ticket and tasks
    public CreateTicketResponse createNewTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket();
        ticket.setTitle(request.getTicketTitle());
        ticket.setDescription(request.getTicketDescription());
        ticket.setStatus(TicketStatus.TODO);

        long ticketId = ticketService.createTicket(ticket);

        List<Task> tasks = request.getTaskNames()
                                  .stream()
                                  .map(name -> {
                                      Task task = new Task();
                                      task.setName(name);
                                      task.setDone(false);
                                      task.setTicketId(ticketId);
                                      return task;
                                  })
                                  .collect(Collectors.toList());

        taskService.addTasks(tasks);

        ticket = ticketService.findTicketById(ticketId);

        return new CreateTicketResponse(TicketMapper.INSTANCE.mapTicket(ticket));
    }

    public void updateTicket(TicketDTO ticketDTO) {

    }

    public void updateTicketStatus(TicketDTO ticketDTO) {
        this.ticketService.updateTicket(TicketMapper.INSTANCE.mapTicketDTO(ticketDTO));
    }

    public void updateTaskName(UpdateTaskNameRequest request) {
        if (request != null && StringUtils.isNotBlank(request.getTaskName())) {
            taskService.updateTaskName(request.getTicketId(), request.getTaskId(), request.getTaskName());
        }
    }

    public long createNewTask(TaskDTO taskDTO) {
        Task task = TaskMapper.INSTANCE.mapTaskDTO(taskDTO);

        if (task != null) {
            return taskService.addTask(task);
        } else {
            return -1;
        }
    }

    public void updateTask(TaskDTO taskDTO) {
        Task task = TaskMapper.INSTANCE.mapTaskDTO(taskDTO);

        if (task != null) {
            taskService.updateTask(task);
        }
    }

    public void updateTaskStatus(UpdateTaskStatusRequest request) {
        taskService.updateTaskStatus(request.getTicketId(), request.getTaskId(), request.isDone());
    }

    public void removeTaskFromTicket(long ticketId, long taskId) {
        taskService.removeTask(ticketId, taskId);
    }
}
