package com.example.demo.core.ddd;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public abstract class EventBase implements Event{
    Object payload;
    Date OccurredOn;
    Map<String, Object> metadata;
    Entity entity;

    public EventBase(Object payload, String eventName) {
        this.payload = payload;
        this.entity = new EntityBases(UUID.randomUUID().toString(), eventName);
    }

    @Override
    public Object Payload() {
        return payload;
    }

    @Override
    public Date OccurredOn() {
        return OccurredOn;
    }

    @Override
    public Map<String, Object> GetMetadata() {
        return metadata;
    }

    @Override
    public String GetID() {
        return entity.GetID();
    }

    @Override
    public void SetID(String id) {
        entity.SetID(id);
    }

    @Override
    public String GetName() {
        return entity.GetName();
    }

    @Override
    public void SetName(String name) {
        entity.SetName(name);
    }
}
