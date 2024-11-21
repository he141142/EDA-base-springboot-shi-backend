package com.example.demo.core.es;

import com.example.demo.core.ddd.Aggregate;

public interface AggregateStore<T extends EsAggregate> {
    T Load(T agg) throws Exception;

    void Save(T aggregate) throws Exception;
}
