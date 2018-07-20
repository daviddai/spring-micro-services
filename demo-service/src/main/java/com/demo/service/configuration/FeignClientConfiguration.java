package com.demo.service.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    Logger.Level feignClientLoggerLevel() {
        return Logger.Level.FULL;
    }

}
