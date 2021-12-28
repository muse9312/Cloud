package com.example.basic.config;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BeanConfig {
    // @Bean
    // public HikariDataSource ds() {
    //     HikariDataSource hds = new HikariDataSource();
    //     hds.setJdbcUrl(jdbcUrl);
    //     hds.setUsername(username);
    //     hds.setPassword(password);
    //     return hds;
    // }
}

