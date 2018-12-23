package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;
import com.kanban.service.impl.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.*;

@Repository
@Qualifier("jdbcTicketDAO")
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    final private static String FIND_ALL_TICKETS = "SELECT id, title, description, status FROM ticket";

    final private static String FIND_TICKET_BY_ID = FIND_ALL_TICKETS + " WHERE ti.id = :ticket_id";

    final private static String UPDATE_TICKET_BY_ID = "UPDATE ticket " +
                                                      "SET title = :title, description = :description, status = :status " +
                                                      "WHERE id = :id";

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
    }

    @Override
    public void add(Ticket ticket) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", ticket.getTitle());
        parameters.put("description", ticket.getDescription());
        parameters.put("status", ticket.getStatus().getDescription());
        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public List<Ticket> findAll() {
        return jdbcTemplate.query(FIND_ALL_TICKETS, resultSet -> {
            List<Ticket> tickets = new ArrayList<>();

            while (resultSet.next()) {
                long ticketId = resultSet.getLong("id");
                String ticketTitle = resultSet.getString("title");
                String ticketDescription = resultSet.getString("description");
                String ticketStatus = resultSet.getString("status");

                tickets.add(new Ticket(ticketId, ticketTitle, ticketDescription, TicketStatus.getTicketStatus(ticketStatus), new ArrayList<>()));
            }

            return tickets;
        });
    }

    @Override
    public Optional<Ticket> findById(long id) {
        Ticket ticket = (Ticket) jdbcTemplate.query(FIND_TICKET_BY_ID, (resultSet, i) -> {
            long ticketId = resultSet.getLong("id");
            String ticketTitle = resultSet.getString("title");
            String ticketDescription = resultSet.getString("description");
            String ticketStatus = resultSet.getString("status");
            return new Ticket(ticketId, ticketTitle, ticketDescription, TicketStatus.valueOf(ticketStatus), new ArrayList<>());
        });

        return Optional.of(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("title", ticket.getTitle())
                                                                           .addValue("description", ticket.getDescription())
                                                                           .addValue("status", ticket.getStatus().getDescription())
                                                                           .addValue("id", ticket.getId());
        jdbcTemplate.update(UPDATE_TICKET_BY_ID, sqlParameterSource);
    }

}
