package sykros.cloud.edacore.internal.am.command;

import lombok.Setter;
import sykros.cloud.edacore.internal.am.MessageBase;
import sykros.cloud.edacore.internal.ddd.Command;
import sykros.cloud.edacore.internal.ddd.EntityBase;

import java.util.Date;
import java.util.UUID;

@Setter
public class CommandMessageBase extends MessageBase implements CommandMessage {
    public CommandMessageBase( String name) {
        super(name);
    }

    Date occurredOn;
    Object payload;

    @Override
    public String CommandName() {
        return this.Name();
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
