package com.example.demo.core.ddd;

import java.util.List;

public interface EventIntegration {
    void AddEvent(Event evt);
    List<Event> GetEvents();
    void ClearEvent();
}
