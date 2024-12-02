package sykros.cloud.edacore.internal.am;

import sykros.cloud.edacore.internal.ddd.EntityBase;

import java.util.Date;
import java.util.UUID;

public abstract class MessageBase extends EntityBase implements IMessageBase {
    public MessageBase(String id, String name) {
        super(id, name);
    }

    String subject;
    Object metadata;
    Date sentAt;

    @Override
    public String Subject() {
        return subject;
    }

    @Override
    public Object Metadata() {
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
