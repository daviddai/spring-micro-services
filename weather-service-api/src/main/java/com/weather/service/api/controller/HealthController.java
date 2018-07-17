package com.weather.service.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
public interface HealthController {

    @GetMapping(path = "/check")
    ResponseEntity<String> check();

    @GetMapping(path = "/ping")
    String ping();

}
