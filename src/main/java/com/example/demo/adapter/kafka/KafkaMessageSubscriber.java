package com.example.demo.adapter.kafka;

import com.example.demo.core.am.MessageHandler;
import com.example.demo.core.am.MessageSubscriber;
import com.example.demo.core.am.SubscriberOption;
import jakarta.annotation.Nullable;

public class KafkaMessageSubscriber implements MessageSubscriber {
    @Override
    public void Subscribe(String topic, MessageHandler messageHandler, @Nullable SubscriberOption subscriberOption) {

    }
}
