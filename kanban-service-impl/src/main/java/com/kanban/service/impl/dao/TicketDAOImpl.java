package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.Optional;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private DataSource dataSource;

    private final static String FIND_ALL_TICKETS = "";

    @Override
    public Collection<Ticket> findAll() {

        return null;
    }

    @Override
    public Optional<Ticket> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void update(Ticket ticket) {

    }
}
