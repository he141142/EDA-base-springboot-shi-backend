package com.example.demo.adapter.kafka;

import com.example.demo.core.am.AmMessageBase;
import com.example.demo.core.am.MessagePublisher;

public class KafkaMessagePublisher implements MessagePublisher {
    @Override
    public <T extends AmMessageBase> void PublishMessage(T message, String topic) {

    }
}
