package sykros.cloud.edacore.internal.ddd.event;

import lombok.Setter;
import sykros.cloud.edacore.internal.ddd.EntityBase;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Setter
public class EventBase extends EntityBase implements IEvent {
    public EventBase(String name) {
        super(UUID.randomUUID().toString(), name);
    }
    public EventBase(String id, String name) {
        super(id, name);
    }

    Object payload;
    Date occurredOn;
    Map<String,Object> metadata;

    @Override
    public Object Payload() {
        return payload;
    }

    @Override
    public Date OccurredOn() {
        return occurredOn;
    }

    @Override
    public Map<String, Object> Metadata() {
        return metadata;
    }
}
