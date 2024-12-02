package sykros.cloud.edacore.internal.ddd.event;

public interface EventSubscriber<T extends IEvent> {
    void subscribe(EventHandler<T> handler, String... events) throws Exception;
}
