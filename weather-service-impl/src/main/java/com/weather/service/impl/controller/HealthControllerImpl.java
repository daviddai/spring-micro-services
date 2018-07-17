package com.weather.service.impl.controller;

import com.weather.service.api.controller.HealthController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthControllerImpl implements HealthController {

    public ResponseEntity<String> check() {
        return ResponseEntity.status(HttpStatus.OK).body("Everything sees fine");
    }

    public String ping() {
        return "pong";
    }
}
