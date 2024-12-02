package com.example.demo.infra.kafka.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = {ElementType.FIELD})
public @interface KafkaConfig {
    String key();
}
