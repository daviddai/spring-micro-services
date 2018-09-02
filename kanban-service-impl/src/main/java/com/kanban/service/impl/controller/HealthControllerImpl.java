package com.kanban.service.impl.controller;

import com.kanban.service.api.controller.HealthController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthControllerImpl implements HealthController {

    @Override
    public String ping() {
        return "pong";
    }
}
