package com.micro.services.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceAppEntry {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceAppEntry.class, args);
    }

}
