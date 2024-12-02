package sykros.cloud.edacore.internal.es;

import sykros.cloud.edacore.internal.ddd.event.IEvent;

public interface EventApplier {
    void Apply(IEvent event) throws Exception;
}
