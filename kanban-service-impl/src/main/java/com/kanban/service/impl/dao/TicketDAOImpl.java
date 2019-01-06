package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@Qualifier("jdbcTicketDAO")
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    final private static String FIND_ALL_TICKETS_WITH_TASKS = "SELECT " +
                                                              "       ti.id as ticket_id, " +
                                                              "       ti.title as ticket_title, " +
                                                              "       ti.description as ticket_description, " +
                                                              "       ti.status as ticket_status, " +
                                                              "       ta.id as task_id, " +
                                                              "       ta.name as task_name, " +
                                                              "       ta.done as task_done " +
                                                              "FROM ticket ti " +
                                                              "LEFT JOIN task ta " +
                                                              "ON ti.id = ta.ticket_id";

    final private static String FIND_TICKET_BY_ID = "SELECT " +
                                                    "       ti.id as ticket_id, " +
                                                    "       ti.title as ticket_title, " +
                                                    "       ti.description as ticket_description, " +
                                                    "       ti.status as ticket_status, " +
                                                    "       ta.id as task_id, " +
                                                    "       ta.name as task_name, " +
                                                    "       ta.done as task_done " +
                                                    "FROM ticket ti " +
                                                    "LEFT JOIN task ta " +
                                                    "ON ti.id = ta.ticket_id " +
                                                    "WHERE ti.id = :ticket_id";

    final private static String UPDATE_TICKET_BY_ID = "UPDATE ticket " +
                                                      "SET title = :title, description = :description, status = :status " +
                                                      "WHERE id = :id";

    final private static String UPDATE_TICKET_STATUS_BY_ID = "UPDATE ticket " +
                                                             "SET status = :status " +
                                                             "WHERE id = :id";

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        simpleJdbcInsert.setTableName("ticket");
        simpleJdbcInsert.setGeneratedKeyName("id");
    }

    @Override
    public long add(Ticket ticket) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", ticket.getTitle());
        parameters.put("description", ticket.getDescription());
        parameters.put("status", ticket.getStatus().getDescription());
        return (long) simpleJdbcInsert.executeAndReturnKey(parameters);
    }

    @Override
    public List<Ticket> findAll() {
        return jdbcTemplate.query(FIND_ALL_TICKETS_WITH_TASKS, resultSet -> {
            Map<Long, Ticket> tickets = new HashMap<>();

            while (resultSet.next()) {
                long ticketId = resultSet.getLong("ticket_id");

                Ticket ticket = tickets.get(ticketId);
                ticket = setTicket(resultSet, ticket);
                tickets.put(ticket.getId(), ticket);
            }

            return new ArrayList<>(tickets.values());
        });
    }

    @Override
    public Optional<Ticket> findById(long id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("ticket_id", id);

        Ticket ticketWithTasks = namedParameterJdbcTemplate.query(FIND_TICKET_BY_ID, sqlParameterSource, resultSet -> {
            Ticket ticket = null;

            while (resultSet.next()) {
                ticket = setTicket(resultSet, ticket);
            }

            return ticket;
        });

        return ticketWithTasks != null ? Optional.of(ticketWithTasks) : Optional.empty();
    }

    @Override
    public void update(Ticket ticket) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("title", ticket.getTitle())
                                                                           .addValue("description", ticket.getDescription())
                                                                           .addValue("status", ticket.getStatus().getDescription())
                                                                           .addValue("id", ticket.getId());
        namedParameterJdbcTemplate.update(UPDATE_TICKET_BY_ID, sqlParameterSource);
    }

    @Override
    public void updateStatus(long ticketId, TicketStatus newTicketStatus) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("status", newTicketStatus.getDescription())
                                                                           .addValue("id", ticketId);
        namedParameterJdbcTemplate.update(UPDATE_TICKET_STATUS_BY_ID, sqlParameterSource);
    }

    private Ticket setTicket(ResultSet resultSet, Ticket ticket) throws SQLException {
        if (ticket == null) {
            ticket = new Ticket();

            long ticketId = resultSet.getLong("ticket_id");
            String ticketTitle = resultSet.getString("ticket_title");
            String ticketDescription = resultSet.getString("ticket_description");
            String ticketStatus = resultSet.getString("ticket_status");

            ticket.setId(ticketId);
            ticket.setTitle(ticketTitle);
            ticket.setDescription(ticketDescription);
            ticket.setStatus(TicketStatus.getTicketStatus(ticketStatus));
        }

        long taskId = resultSet.getLong("task_id");
        if (!resultSet.wasNull()) {
            String taskName = resultSet.getString("task_name");
            boolean done = resultSet.getBoolean("task_done");
            ticket.getTasks().add(new Task(taskId, taskName, done, ticket.getId()));
        }

        return ticket;
    }

}
