package com.example.demo.core.cqs;

import java.util.Date;
import java.util.Map;

public interface Command<P> {
    String GetID();
    Object GetPayload();
    Map<String, Object> GetMetadata();
    Date OccurredOn();
}
