package com.example.demo.core.ddd;

import java.util.List;

public abstract class AggregateBase implements Aggregate {
    private String id;
    private String name;
    private int version = 0;
    protected List<Event> events;

    public AggregateBase(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int AggregateVersion() {
        return version;
    }

    @Override
    public String GetID() {
        return id;
    }

    @Override
    public void SetID(String id) {
        this.id = id;
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public void AddEvent(Event evt) {
        events.add(evt);
    }

    @Override
    public List<Event> GetEvents() {
        return events;
    }

    @Override
    public void ClearEvent() {
        events.clear();
    }

    protected void IncreaseVersion() {
        version++;
    }
}
