package sykros.cloud.edacore.internal.am;

public interface MessagePublisher {
    void Publish(String topic, IMessageBase message) throws Exception;
}
