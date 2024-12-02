package com.example.demo.infra.kafka.config;

import com.example.demo.infra.kafka.factories.SysConsumerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    static final Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Bean
    SysConsumerFactory sysConsumerFactory() {
        System.out.println("SysConsumerFactory Bean Created");
        return new SysConsumerFactory();
    }
}
