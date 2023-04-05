package com.example.demo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:db.properties", ignoreResourceNotFound = true)
@PropertySource("classpath:application.properties")
public class DBConfig {
    @Autowired
    Environment environment;

    @Bean
    public DBConnection getDBConnection(@Value("${app.name}") String appName) {
        System.out.println("Getting DBConnection Bean for App: " + appName);
        DBConnection dbConnection = new DBConnection(
                environment.getProperty("db.driver.class"),
                environment.getProperty("db.url"),
                environment.getProperty("db.username"),
                environment.getProperty("db.password").toCharArray());
        return dbConnection;
    }
}
