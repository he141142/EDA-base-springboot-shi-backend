package com.example.demo.core.es;

import com.example.demo.core.ddd.AggregateBase;


public abstract class BaseESAggregate extends AggregateBase implements EsAggregate{
    int version = 0;

    public BaseESAggregate(String id, String name) {
        super(id, name);
    }

    @Override
    public int Version() {
        return version;
    }

    @Override
    public int PendingVersion() {
        return this.version + this.events.size();
    }

    @Override
    public void SetVersion(int version) {
        this.version = version;
    }


    @Override
    public void CommitAll() {
        this.version += this.events.size();
        this.ClearEvent();
    }
}
