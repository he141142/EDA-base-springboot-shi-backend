package sykros.cloud.edacore.internal.am.event;

import lombok.Setter;
import sykros.cloud.edacore.internal.am.MessageBase;

import java.util.Date;

@Setter
public class EventMessageBase extends MessageBase implements EventMessage {
    Object payload;
    Date occurredOn;
    public EventMessageBase(String name) {
        super(name);
    }

    public EventMessageBase(String name, Object payload) {
        super(name);
        this.payload = payload;
    }


    @Override
    public Object Payload() {
        return payload;
    }

    @Override
    public Date OccurredOn() {
        return occurredOn;
    }
}
