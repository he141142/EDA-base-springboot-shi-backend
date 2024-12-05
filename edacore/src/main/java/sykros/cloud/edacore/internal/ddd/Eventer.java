package sykros.cloud.edacore.internal.ddd;

import sykros.cloud.edacore.internal.ddd.event.IEvent;

import java.util.List;

public interface Eventer {
    void AddEvent(IEvent event);

    void ClearEvents();

    List<IEvent> Events();
}
