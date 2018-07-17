package com.weather.service.impl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.weather.service.impl.controller"})
public class AppEntry {

    public static void main(String[] args) {
        SpringApplication.run(AppEntry.class);
    }

}
