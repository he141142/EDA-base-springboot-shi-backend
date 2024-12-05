package sykros.cloud.edacore.internal.am;

// common interface for all message subscribers
public interface MessageSubscriber {
    Subscription Subscribe(String topic, MessageHandler handler, SubscriberConfig config) throws Exception;
}
