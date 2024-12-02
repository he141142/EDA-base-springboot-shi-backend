package sykros.cloud.edacore.internal.ddd.event;

public interface EventHandler<T extends IEvent> {
    void handle(T event) throws Exception;
}
