package com.example.demo.core.es;

import com.example.demo.core.ddd.Event;

public interface EventApplier {
   void ApplyEvent(Event event);
}
