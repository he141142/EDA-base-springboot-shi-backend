package sykros.cloud.edacore.internal.ddd;

import sykros.cloud.edacore.internal.ddd.event.IEvent;

import java.util.List;
import java.util.UUID;

public class AggregateBase extends EntityBase implements IAggregate {

    protected List<IEvent> events;

    public AggregateBase(String id, String name) {
        super(id, name);
    }

    public AggregateBase(String name) {
        super(UUID.randomUUID().toString(), name);
    }

    @Override
    public void AddEvent(IEvent event) {
        this.events.add(event);
    }

    @Override
    public void ClearEvents() {
        this.events.clear();
    }

    @Override
    public List<IEvent> Events() {
        return this.events;
    }
}
