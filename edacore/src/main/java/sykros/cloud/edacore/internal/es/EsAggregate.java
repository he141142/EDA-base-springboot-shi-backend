package sykros.cloud.edacore.internal.es;

import sykros.cloud.edacore.internal.ddd.IAggregate;

public interface EsAggregate extends IAggregate, IEventCommitter, IVersioner {
}
