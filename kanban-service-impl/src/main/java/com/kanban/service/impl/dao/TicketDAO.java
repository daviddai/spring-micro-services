package com.kanban.service.impl.dao;

import com.kanban.service.impl.model.Ticket;

import java.util.Collection;

public interface TicketDAO {

    public Collection<Ticket> findAll();

}
