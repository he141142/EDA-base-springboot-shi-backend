package sykros.cloud.edacore.internal.ddd.event;

import java.util.HashMap;
import java.util.Map;

public final class EventHandlerBase<T extends  IEvent>{
    EventHandler<T> handler;
    Map<String, Boolean> filters = new HashMap<>();

    public EventHandlerBase(EventHandler<T> handler, Map<String, Boolean> filters){
        this.handler = handler;
        this.filters = filters;
    }
}
