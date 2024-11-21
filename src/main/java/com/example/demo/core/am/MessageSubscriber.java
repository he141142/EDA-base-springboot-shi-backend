package com.example.demo.core.am;

import jakarta.annotation.Nullable;

public interface MessageSubscriber {
    void Subscribe(String topic, MessageHandler messageHandler,@Nullable SubscriberOption subscriberOption);
}
