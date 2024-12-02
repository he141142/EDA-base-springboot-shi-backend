package sykros.cloud.edacore.internal.ddd;

import sykros.cloud.edacore.internal.ddd.event.IEvent;

public interface Eventer {
    void AddEvent(IEvent event);

    void ClearEvents();

    Iterable<IEvent> Events();
}
