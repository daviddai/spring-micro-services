package com.web.service.impl.controller;

import com.web.service.api.controller.HealthController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
public class HealthControllerImpl implements HealthController {

    public ResponseEntity<String> check() {
        return ResponseEntity.status(HttpStatus.OK).body("Everything sees fine");
    }

    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }
}
