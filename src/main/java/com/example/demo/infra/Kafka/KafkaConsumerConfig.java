package com.example.demo.infra.Kafka;

import jakarta.annotation.Nullable;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);

        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }



    @KafkaListener(topics = "drake", groupId = "group2",topicPartitions = { @TopicPartition(topic = "drake", partitions = { "1" }) })
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,

                                @Nullable @Header("{dsasadsadsad}") String d) {
        if (d != null) {
            System.out.println("Received Message: " + message + " from partition: " + partition + " in group2"+ " "+d);
        }else {
            System.out.println("Received Message: " + message + " from partition: " + partition + " in group2");

        }
    }

    @KafkaListener( groupId = "group2", topicPartitions = { @TopicPartition(topic = "drake", partitions = { "0" }) })
    public void listenWithHeaders2(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        System.out.println("listenWithHeaders2 Received Message: " + message + " from partition: " + partition + " in group2");
    }
}
