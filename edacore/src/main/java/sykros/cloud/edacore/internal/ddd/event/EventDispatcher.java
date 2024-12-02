package sykros.cloud.edacore.internal.ddd.event;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcher <T extends IEvent> implements EventPublisher<T> , EventSubscriber<T> {
    List<EventHandlerBase<T>> handlers = new ArrayList<>();

    @SafeVarargs
    @Override
    public final void publish(T... events) throws Exception {
        for (T event : events) {
            for (EventHandlerBase<T> handler : handlers) {
                if (handler.filters.containsKey(event.Name())) {
                    handler.handler.handle(event);
                }
            }
        }
    }

    @Override
    public void subscribe(EventHandler<T> handler, String... events) throws Exception {
        Map<String, Boolean> filters = new HashMap<>();
        for (String event : events) {
            if (event == null || event.isEmpty()) {
                continue;
            }
            filters.put(event, true);
        }

        handlers.add(new EventHandlerBase<>(handler, filters));
    }
}
