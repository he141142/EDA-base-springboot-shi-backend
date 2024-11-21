package com.example.demo.core.ddd;


import java.util.Date;
import java.util.Map;

public interface Event extends Entity{
    Map<String, Object> GetMetadata();

    Object Payload();

    Date OccurredOn();
}
