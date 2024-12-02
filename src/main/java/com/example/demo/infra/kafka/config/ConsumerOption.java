package com.example.demo.infra.kafka.config;

import com.example.demo.core.am.SubscriberOption;
import lombok.*;
import org.slf4j.Logger;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsumerOption extends SubscriberOption {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(ConsumerOption.class);

    @KafkaConfig(key = "consumer.name")
    String consumerName;

    @KafkaConfig(key = "group.id")
    String groupID;

    @KafkaConfig(key = "auto-offset-reset")
    boolean AutoOffsetReset;

    @KafkaConfig(key = "key.deserializer")
    String keyDeserializer;

    @KafkaConfig(key = "value.deserializer")
    String valueDeserializer;

    @KafkaConfig(key = "enable-auto-commit")
    int maxPollRecords;

    @KafkaConfig(key = "max-poll-records")
    int maxPollIntervalMs;

    public Map<String, Object> buildProperty() {
        Class<ConsumerOption> consumerOptionClass = ConsumerOption.class;
        Map<String, Object> properties = new HashMap<>();
        for (java.lang.reflect.Field field : consumerOptionClass.getDeclaredFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;
                }

                if (!field.canAccess(this)) {
                    field.setAccessible(true);
                }
                KafkaConfig kafkaConfig = field.getAnnotation(KafkaConfig.class);
                if (kafkaConfig == null) {
                    continue;
                }

                properties.put(kafkaConfig.key(), field.get(this));
            } catch (IllegalAccessException e) {
                logger.error("Error while building properties for consumer option: {}", e.getMessage());
                return null;
            }


        }
        return properties;
    }

    public static class ConsumerOptionBuilder extends SubscriberOptionBuilder{
        public ConsumerOptionBuilder() {
            super();
        }
    }
}
