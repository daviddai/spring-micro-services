package com.kanban.service.impl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"com.kanban.service.impl"})
public class KanbanAppEntry {

    public static void main(String[] args) {
        SpringApplication.run(KanbanAppEntry.class, args);
    }

}
