package com.example.demo.adapter.kafka;

import com.example.demo.core.am.AmInComingMessage;
import com.example.demo.core.am.MessageHandler;
import com.example.demo.core.am.MessageSubscriber;
import com.example.demo.core.am.SubscriberOption;
import jakarta.annotation.Nullable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;


@Component
@Qualifier("KafkaMessageSubscriber")
public class KafkaMessageSubscriber implements MessageSubscriber {

    ConcurrentKafkaListenerContainerFactory<String, AmInComingMessage> factory;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaMessageSubscriber.class);

    @Autowired
    @Qualifier("CommandKafkaListenerContainerFactory")
    public void setFactory(ConcurrentKafkaListenerContainerFactory<String, AmInComingMessage> factory) {
        this.factory = factory;
    }


    @Override
    public void Subscribe(String topic, MessageHandler messageHandler, @Nullable SubscriberOption subscriberOption) {
        ConcurrentMessageListenerContainer<String, AmInComingMessage> container = factory.createContainer(topic);
        container.setupMessageListener((MessageListener<String, AmInComingMessage>) record -> {
            try {
                AmInComingMessage v = record.value();
                System.out.println(v.getId());
                // Process each message
                System.out.println(v.getName());
                System.out.println("Received message: " + record.value().getId());
                messageHandler.HandleMessage(v);
                // Acknowledge processing (if needed)
                // Simulate acknowledgment logic if required
            } catch (Exception e) {
                System.err.println("Error processing message: " + record.value());
                e.printStackTrace();
            }
        });
        container.start();
        Runtime.getRuntime().addShutdownHook(new Thread(container::stop));
    }
}
