package com.example.demo.pkg;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.kafka.clients.consumer.internals.Deserializers;

import java.io.IOException;

public class SykrosJsonDeserializer extends JsonDeserializer<Class<?>> {
    @Override
    public Class<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        return null;
    }
}
