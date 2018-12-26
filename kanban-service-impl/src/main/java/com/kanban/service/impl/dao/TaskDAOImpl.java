package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
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
import java.util.Collection;

@Qualifier("jdbcTaskDAO")
@Repository
public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    private final static String UPDATE_TASK = "UPDATE task " +
                                              "SET name = :name, " +
                                              "    done = :done " +
                                              "WHERE id = :id AND ticket_id = :ticket_id";

    private final static String UPDATE_TASK_STATUS = "UPDATE task " +
                                                     "SET done = :done " +
                                                     "WHERE id = :id AND ticket_id = :ticket_id";

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
    }

    @Override
    public Collection<Task> findAllByTicketId(long ticketId) {
        return null;
    }

    @Override
    public void update(Task task) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("name", task.getName())
                                                                           .addValue("done", task.isDone())
                                                                           .addValue("id", task.getId())
                                                                           .addValue("ticket_id", task.getTicketId());
        namedParameterJdbcTemplate.update(UPDATE_TASK, sqlParameterSource);
    }

    @Override
    public void updateStatus(long ticketId, long taskId, boolean done) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("done", done)
                                                                           .addValue("id", taskId)
                                                                           .addValue("ticket_id", ticketId);
        namedParameterJdbcTemplate.update(UPDATE_TASK_STATUS, sqlParameterSource);
    }
}