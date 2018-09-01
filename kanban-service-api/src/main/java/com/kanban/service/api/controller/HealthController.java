package com.kanban.service.api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
public interface HealthController {

    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> ping();

}
