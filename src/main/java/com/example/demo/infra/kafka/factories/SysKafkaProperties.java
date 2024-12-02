package com.example.demo.infra.kafka.factories;

import com.example.demo.infra.kafka.config.ConsumerOption;
import lombok.*;
import org.apache.kafka.clients.CommonClientConfigs;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SysKafkaProperties {

    @org.springframework.beans.factory.annotation.Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @org.springframework.beans.factory.annotation.Value("${spring.kafka.client-id}")
    private String clientID;
    private Map<String, String> properties;

    @Setter
    @Getter
    private Map<String, ConsumerOption> consumerConfig = new HashMap<>() {{
        put("default", new ConsumerOption());
        put("sykros.command", new ConsumerOption.ConsumerOptionBuilder()
                .consumerName("sykros.command")
                .groupID("sykros-command")
                .AutoOffsetReset(true)
                .keyDeserializer("org.apache.kafka.common.serialization.StringDeserializer")
                .valueDeserializer("com.example.demo.infra.kafka.deserializer.IcommingMessageDeserializer")
                .maxPollRecords(1)
                .maxPollIntervalMs(1000)
                .build());
    }};

    private Map<String, KafkaProperties.Producer> producerConfig;


    public Map<String, Object> buildCommonProperties() {
        Map<String, Object> properties = new java.util.HashMap<>();
        assert bootstrapAddress != null;
        properties.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        properties.put(CommonClientConfigs.CLIENT_ID_CONFIG, clientID);
        if (this.properties != null && !this.properties.isEmpty()) {
            properties.putAll(this.properties);
        }
        return properties;
    }
}
