package sykros.cloud.edacore.internal.ddd.event;

import sykros.cloud.edacore.internal.ddd.EntityBase;

import java.util.Date;
import java.util.UUID;

public class EventBase extends EntityBase implements IEvent {
    public EventBase(String name) {
        super(UUID.randomUUID().toString(), name);
    }

    Object payload;
    Date occurredOn;
    Object metadata;

    @Override
    public Object Payload() {
        return payload;
    }

    @Override
    public Date OccurredOn() {
        return occurredOn;
    }

    @Override
    public Object Metadata() {
        return metadata;
    }
}
