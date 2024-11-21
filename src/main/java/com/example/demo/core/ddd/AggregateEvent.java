package com.example.demo.core.ddd;

public interface AggregateEvent extends Event {
    String AggregateName();

    String AggregateID();

    int AggregateVersion();
}
