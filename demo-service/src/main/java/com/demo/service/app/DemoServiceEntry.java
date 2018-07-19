package com.demo.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@ImportAutoConfiguration(FeignAutoConfiguration.class)
@ComponentScan({"com.demo.service.controller"})
public class DemoServiceEntry {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceEntry.class);
    }

}
