package com.example.demo.core.es;

import com.example.demo.core.ddd.Aggregate;

/* EsAggregate is a mix of ddd.Aggregate because some domain may not apply es but apply aggregate */
public interface EsAggregate extends Aggregate, ESVersion, EventCommiter, EventApplier {
}
