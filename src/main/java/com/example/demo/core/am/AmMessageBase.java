package com.example.demo.core.am;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
public abstract class AmMessageBase implements IAmMessageBase {
    String id;
    String name;
    String subject;
    byte[] body;
    Date sentAt;
    Map<String, Objects> metadata;

    @Override
    public Map<String, Objects> metadata() {
        return metadata;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String subject() {
        return subject;
    }

    @Override
    public byte[] body() {
        return body;
    }

    @Override
    public Date sentAt() {
        return sentAt;
    }
}
