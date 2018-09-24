package com.tw.beijing.jpa_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JpaStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaStartApplication.class, args);
    }
}
