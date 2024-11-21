package com.example.demo.infra.Kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(KafkaTopicConfig.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        logger.log(org.apache.logging.log4j.Level.INFO, "Kafka Admin Bean Created");
        logger.log(org.apache.logging.log4j.Level.INFO, bootstrapServers);
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return new KafkaAdmin(configs);
    }

}
