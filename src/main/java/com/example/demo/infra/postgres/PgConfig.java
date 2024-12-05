package com.example.demo.infra.postgres;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PgConfig {
    @Value("${spring.datasource.jpa.properties.hibernate.default_schema}")
    String schema;

    @Value("${spring.datasource.username}")
    String userName;

    @Value("${spring.datasource.url}")
    String url;
}
