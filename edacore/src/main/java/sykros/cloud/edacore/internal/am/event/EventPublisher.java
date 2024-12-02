package sykros.cloud.edacore.internal.am.event;

import sykros.cloud.edacore.internal.ddd.event.IEvent;

public interface EventPublisher {
    void Publish(String topic, IEvent event) throws Exception;
}
