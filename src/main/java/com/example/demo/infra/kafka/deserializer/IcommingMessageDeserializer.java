package com.example.demo.infra.kafka.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.core.am.AmInComingMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class IcommingMessageDeserializer implements Deserializer<AmInComingMessage> {

    @Override
    public AmInComingMessage deserialize(String s, byte[] bytes) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = new String(bytes);
        try {
            JSONObject jsonObj = JSON.parseObject(json);
            Class<?> clazz = Class.forName("com.example.demo.core.am.AmInComingMessage");
            clazz = clazz.getSuperclass();
            return toAmInComingMessage(jsonObj,clazz);
        } catch (ClassNotFoundException  e) {
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private AmInComingMessage toAmInComingMessage(JSONObject jsonObject,Class<?> clazz) throws IllegalAccessException {
        AmInComingMessage message = new AmInComingMessage();
        for (var field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            var anno = field.getAnnotation(JsonProperty.class);
            if (anno == null) {
                continue;
            }
            if (!jsonObject.containsKey(anno.value())) {
                continue;
            }
            if (field.getType().isArray() && field.getType().getComponentType().equals(byte.class) ){
                field.set(message, jsonObject.get(anno.value()).toString().getBytes());
                continue;
            }
            field.set(message, jsonObject.get(anno.value()));
        }
        return message;
    }
}
