package sykros.cloud.edacore.internal.cqs;

import sykros.cloud.edacore.internal.ddd.Query;

public interface QueryHandler<O, Q extends Query<O>> {
    O HandleQuery(Q query) throws Exception;
}
