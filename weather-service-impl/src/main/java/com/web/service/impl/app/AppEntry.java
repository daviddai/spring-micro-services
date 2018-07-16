package com.web.service.impl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.web.service.impl.controller"})
public class AppEntry {

    public static void main(String[] args) {
        SpringApplication.run(AppEntry.class);
    }

}
