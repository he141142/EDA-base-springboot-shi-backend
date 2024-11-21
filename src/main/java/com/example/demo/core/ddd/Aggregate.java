package com.example.demo.core.ddd;

// aggregate enable domain can be able to implement event integration
public interface Aggregate extends Entity, EventIntegration {
    int AggregateVersion();
}
