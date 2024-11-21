package com.example.demo.core.am;

public class ReplyPublisher implements MessagePublisher {
    // for real implementation, we need to inject the messagePublisher, may be kafka or rabbitmq
    MessagePublisher messagePublisher;

    @Override
    public <T extends AmMessageBase> void PublishMessage(T message,String topic) {
        AmReplyMessage replyMessage = (AmReplyMessage) message;
        messagePublisher.PublishMessage(replyMessage,topic);
    }
}
