package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.TicketController;
import com.kanban.service.api.model.TicketDTO;
import com.kanban.service.impl.manager.TicketManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TicketControllerImpl implements TicketController {

    private TicketManager ticketManager;

    @Override
    public ResponseEntity<List<TicketDTO>> getAll() {
        return null;
    }

}
