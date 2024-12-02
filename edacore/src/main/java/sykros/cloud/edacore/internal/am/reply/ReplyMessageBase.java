package sykros.cloud.edacore.internal.am.reply;

import lombok.Setter;
import sykros.cloud.edacore.internal.am.MessageBase;

import java.util.Date;

@Setter
public class ReplyMessageBase extends MessageBase implements ReplyMessage {
    public ReplyMessageBase(String name) {
        super(name);
    }

    Object payload;
    Date occurredOn;


    @Override
    public String ReplyName() {
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
