package com.demo.service.controller;

import com.demo.service.client.WeatherServiceHealthCheckClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/consume-weather-service")
public class DemoController {
    @Autowired
    private WeatherServiceHealthCheckClient weatherServiceHealthCheckClient;

    @GetMapping(path = "/health-condition")
    public String getWeatherServiceHealthCondition() {
        return this.weatherServiceHealthCheckClient.check().getBody();
    }

    @GetMapping(path = "/ping-response")
    public String getWeatherServicePingResponse() {
        return this.weatherServiceHealthCheckClient.ping();
    }

}
