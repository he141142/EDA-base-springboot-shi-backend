package com.example.demo.core.cqs;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public abstract class CommandBase<P> implements Command<P>, Serializable {
    String id;
    Object payload;
    Map<String, Object> metadata;
    Date occurredOn;

    public CommandBase() {
        id = UUID.randomUUID().toString();
        payload = this;
        occurredOn = new Date();
    }

    @Override
    public String GetID() {
        return id;
    }

    @Override
    public Object GetPayload() {
        return payload;
    }

    @Override
    public Map<String, Object> GetMetadata() {
        return metadata;
    }

    @Override
    public Date OccurredOn() {
        return occurredOn;
    }
}
