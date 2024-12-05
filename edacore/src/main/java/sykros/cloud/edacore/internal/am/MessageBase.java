package sykros.cloud.edacore.internal.am;

import lombok.Setter;
import sykros.cloud.edacore.internal.ddd.EntityBase;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Setter
public abstract class MessageBase extends EntityBase implements IMessageBase {
    public MessageBase(String id, String name) {
        super(id, name);
    }

    String subject;
    Map<String,Object>  metadata;
    Date sentAt;

    @Override
    public String Subject() {
        return subject;
    }

    @Override
    public Map<String,Object> Metadata() {
        return metadata;
    }

    @Override
    public Date SentAt() {
        return sentAt;
    }

    public MessageBase(String name) {
        super(UUID.randomUUID().toString(), name);
    }

}
