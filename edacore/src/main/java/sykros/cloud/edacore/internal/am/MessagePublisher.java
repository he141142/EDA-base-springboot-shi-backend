package sykros.cloud.edacore.internal.am;

// common interface for all messages published to the message bus
public interface MessagePublisher {
    void Publish(String topic, IMessage message) throws Exception;
}
