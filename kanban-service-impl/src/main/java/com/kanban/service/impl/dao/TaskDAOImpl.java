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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    private final static String UPDATE_TASK_NAME = "UPDATE task " +
                                                   "SET name = :name " +
                                                   "WHERE id = :id AND ticket_id = :ticket_id";

    private final static String UPDATE_TASK_STATUS = "UPDATE task " +
                                                     "SET done = :done " +
                                                     "WHERE id = :id AND ticket_id = :ticket_id";

    private final static String DELETE_TASK = "DELETE FROM task " +
                                              "WHERE id = :id AND ticket_id = :ticket_id";

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        simpleJdbcInsert.setTableName("task");
        simpleJdbcInsert.setGeneratedKeyName("id");
    }

    @Override
    public long add(Task task) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", task.getName());
        parameters.put("done", task.isDone());
        parameters.put("ticket_id", task.getTicketId());
        return (long) simpleJdbcInsert.executeAndReturnKey(parameters);
    }

    @Override
    public void addBatch(List<Task> tasks) {
        SqlParameterSource[] sqlParameterSources = new MapSqlParameterSource[tasks.size()];

        List<SqlParameterSource> sqlParameterSourceList = tasks.stream()
                .map(task -> new MapSqlParameterSource().addValue("name", task.getName())
                                                        .addValue("done", task.isDone())
                                                        .addValue("ticket_id", task.getTicketId()))
                .collect(Collectors.toList());

        sqlParameterSources = sqlParameterSourceList.toArray(sqlParameterSources);

        simpleJdbcInsert.executeBatch(sqlParameterSources);
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

    @Override
    public void updateName(long ticketId, long taskId, String name) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", taskId)
                                                                           .addValue("ticket_id", ticketId)
                                                                           .addValue("name", name);
        namedParameterJdbcTemplate.update(UPDATE_TASK_NAME, sqlParameterSource);
    }

    @Override
    public void delete(long ticketId, long taskId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", taskId)
                                                                           .addValue("ticket_id", ticketId);

        namedParameterJdbcTemplate.update(DELETE_TASK, sqlParameterSource);
    }
}
