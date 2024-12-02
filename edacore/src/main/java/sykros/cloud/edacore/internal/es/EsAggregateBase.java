package sykros.cloud.edacore.internal.es;

import sykros.cloud.edacore.internal.ddd.AggregateBase;

public abstract class EsAggregateBase extends AggregateBase implements EsAggregate {
    int version;

    public EsAggregateBase(String name) {
        super(name);
    }

    @Override
    public void CommitEvents() {
        this.version += this.events.size();
        this.ClearEvents();
    }

    @Override
    public void SetVersion(int version) {
        this.version = version;
    }

    @Override
    public int PendingVersion() {
        return version + this.events.size();
    }

    @Override
    public int CurrentVersion() {
        return version;
    }
}
