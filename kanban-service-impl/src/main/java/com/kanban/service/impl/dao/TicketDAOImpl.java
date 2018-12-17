package com.kanban.service.impl.dao;

import com.google.common.annotations.VisibleForTesting;
import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    final private static String FIND_ALL_TICKETS = "SELECT " +
                                                   "ti.id as ticket_id, ti.title as ticket_title, ti.description as ticket_description, ti.status as ticket_status " +
                                                   "ta.id as task_id, ta.name as task_name, ta.done as task_status" +
                                                   "FROM ticket ti" +
                                                   "LEFT JOIN task ta " +
                                                   "ON ti.id = ta.ticket_id";

    final private static String FIND_TICKET_BY_ID = FIND_ALL_TICKETS + " WHERE ti.id = :ticket_id";

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add(Ticket ticket) {

    }

    @Override
    public Collection<Ticket> findAll() {
        Map<Long, Ticket> tickets = new HashMap<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_ALL_TICKETS);

        for (Map<String, Object> row: rows) {
            long ticketId = (long) row.get("ticekt_id");

            Ticket ticket = null;

            if (tickets.containsKey(ticketId)) {
                ticket = tickets.get(ticketId);
            } else {
                ticket = mapRowToTicket(row);

                if (ticket == null) {
                    continue;
                }
            }

            if (row.get("task_id") != null ) {
                ticket.getTasks().add(mapRowToTask(row));
            }

            tickets.put(ticketId, ticket);
        }

        return new ArrayList<>(tickets.values());
    }

    @Override
    public Optional<Ticket> findById(long id) {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FIND_TICKET_BY_ID, new MapSqlParameterSource("ticket_id", id));

        if (CollectionUtils.isEmpty(rows)) {
            return Optional.empty();
        }

        Ticket ticket = null;

        for (Map<String, Object> row: rows) {
            if (ticket == null) {
                ticket = mapRowToTicket(row);

                if (ticket == null) {
                    return Optional.empty();
                }
            }

            ticket.getTasks().add(mapRowToTask(row));
        }

        return Optional.of(ticket);
    }

    @Override
    public void update(Ticket ticket) {

    }

    @VisibleForTesting
    Ticket mapRowToTicket(Map<String, Object> row) {
        if (row == null) {
            return null;
        } else {
            long ticketId = (long) row.get("ticket_id");
            String title = (String) row.get("ticket_title");
            String description = (String) row.get("ticket_description");
            TicketStatus ticketStatus;
            try {
                ticketStatus = TicketStatus.getTicketStatus((String) row.get("ticket_status"));
            } catch (IllegalArgumentException ex) {
                return null;
            }

            return  new Ticket(ticketId, title, description, ticketStatus, new ArrayList<>());
        }
    }

    @VisibleForTesting
    Task mapRowToTask(Map<String, Object> row) {
        if (row == null) {
            return null;
        } else {
            long taskId = (long) row.get("task_id");
            String taskName = (String) row.get("task_name");
            boolean done = (boolean) row.get("task_status");
            return new Task(taskId, taskName, done);
        }
    }

}
