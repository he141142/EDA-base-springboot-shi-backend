package com.example.demo.core.cqs;

public interface QueryHandler<Q, C extends Query<Q>> {
    Q HandleQuery(C query);
}
