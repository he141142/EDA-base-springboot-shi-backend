package sykros.cloud.edacore.internal.am.reply;

import lombok.Setter;
import sykros.cloud.edacore.internal.am.MessageBase;

import java.util.Date;
import java.util.Map;

@Setter
public class ReplyMessageBase extends MessageBase implements ReplyMessage {
    public ReplyMessageBase(String name) {
        super(name);
    }

    public ReplyMessageBase(String id, String name) {
        super(id, name);
    }

    Object payload;
    Date occurredOn;
    Map<String,Object> metadata;


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
