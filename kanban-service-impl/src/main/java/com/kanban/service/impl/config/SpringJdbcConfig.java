package com.kanban.service.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.kanban.service.impl.dao.*")
public class SpringJdbcConfig {

    @Bean
    public DataSource mysqlDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        // todo: find to way to make this app work with mysql which runs in another docker container without specifying ip address
        dataSource.setUrl("jdbc:mysql://192.168.1.2:3306/kanban_board");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }
}
