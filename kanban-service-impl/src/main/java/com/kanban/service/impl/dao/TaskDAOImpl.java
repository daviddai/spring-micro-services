package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

    private final static String UPDATE_TASK = "UPDATE task " +
                                              "SET name = :name, " +
                                              "    done = :done " +
                                              "WHERE id = :id AND ticket_id = ticket:id";

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Collection<Task> findAllByTicketId(long ticketId) {
        return null;
    }

    @Override
    public void update(long ticketId, Task task) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("name", task.getName())
                                                                           .addValue("done", task.isDone())
                                                                           .addValue("id", task.getId())
                                                                           .addValue("ticket_id", ticketId);
        jdbcTemplate.update(UPDATE_TASK, sqlParameterSource);
    }
}
