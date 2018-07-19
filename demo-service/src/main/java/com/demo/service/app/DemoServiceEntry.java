package com.demo.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.demo.service.client"})
@ComponentScan("com.demo.service")
public class DemoServiceEntry {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceEntry.class);
    }

}
