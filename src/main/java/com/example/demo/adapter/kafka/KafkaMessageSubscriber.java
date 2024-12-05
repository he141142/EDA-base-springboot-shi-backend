package com.example.demo.adapter.kafka;

import jakarta.annotation.Nullable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;
import sykros.cloud.edacore.internal.am.*;


@Component
@Qualifier("KafkaMessageSubscriber")
public class KafkaMessageSubscriber implements MessageSubscriber {

    ConcurrentKafkaListenerContainerFactory<String, IIncomingMessage> factory;
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaMessageSubscriber.class);

    @Autowired
    @Qualifier("CommandKafkaListenerContainerFactory")
    public void setFactory(ConcurrentKafkaListenerContainerFactory<String, IIncomingMessage> factory) {
        this.factory = factory;
    }

    @Override
    public Subscription Subscribe(String topic, MessageHandler handler, SubscriberConfig subscriberConfig) throws Exception {
        ConcurrentMessageListenerContainer<String, IIncomingMessage> container = factory.createContainer(topic);
        container.setupMessageListener((MessageListener<String, IIncomingMessage>) record -> {
            try {
                IIncomingMessage incomingMessage = record.value();
                // Process each message
                System.out.println(incomingMessage.Name());
                System.out.println("Received message: " + record.value().ID());
                handler.HandleMessage(incomingMessage);
                // Acknowledge processing (if needed)
                // Simulate acknowledgment logic if required
            } catch (Exception e) {
                System.err.println("Error processing message: " + record.value());
                logger.error(e.getMessage());
            }
        });
        container.start();
        Runtime.getRuntime().addShutdownHook(new Thread(container::stop));
        return null;
    }
}
