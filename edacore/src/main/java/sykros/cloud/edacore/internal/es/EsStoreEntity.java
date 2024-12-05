package sykros.cloud.edacore.internal.es;

import sykros.cloud.edacore.internal.ddd.Entity;

public interface EsStoreEntity extends Entity,EventApplier,IEventCommitter,IVersioner {
}
