package com.demo.service.client;

import com.weather.service.api.controller.HealthController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "weather-service-client")
public interface WeatherServiceHealthCheckClient extends HealthController {}
