package com.example.demo.core.am;

public interface MessagePublisher {
    <T extends AmMessageBase>void PublishMessage(T message,String topic);
}
