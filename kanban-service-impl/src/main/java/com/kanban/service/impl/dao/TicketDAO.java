package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;

import java.util.Collection;
import java.util.Optional;

public interface TicketDAO {

    public Collection<Ticket> findAll();

    public Optional<Ticket> findById(long id);

    public void update(Ticket ticket);

}
