package sykros.cloud.edacore.internal.ddd.event;

public interface EventPublisher<T extends IEvent> {
    void publish(T ...events) throws Exception;
}
