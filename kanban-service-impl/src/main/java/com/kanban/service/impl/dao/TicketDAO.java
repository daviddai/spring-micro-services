package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketDAO {

    long add(Ticket ticket);

    List<Ticket> findAll();

    Optional<Ticket> findById(long id);

    void update(Ticket ticket);

}
