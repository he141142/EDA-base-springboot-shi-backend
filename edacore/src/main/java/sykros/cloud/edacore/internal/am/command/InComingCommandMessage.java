package sykros.cloud.edacore.internal.am.command;

import lombok.Setter;
import sykros.cloud.edacore.internal.am.IIncomingMessage;
import sykros.cloud.edacore.internal.am.MessageBase;

import java.util.Date;

@Setter
public class InComingCommandMessage extends CommandMessageBase implements IIncomingMessage {
    public InComingCommandMessage(String name) {
        super(name);
    }

    Object payload;

    Date receivedAt;

    @Override
    public Date ReceivedAt() {
        return receivedAt;
    }

    @Override
    public Object data() {
        return payload;
    }
}
