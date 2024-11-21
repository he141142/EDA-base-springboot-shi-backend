package com.example.demo.core.am;

import com.example.demo.core.cqs.CommandBase;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class AmCommandMessage<T> extends CommandBase<T> implements IAmMessageBase {
    IAmMessageBase amMessageBase;

    public AmCommandMessage(AmMessageBase amMessageBase) {
        this.amMessageBase = amMessageBase;
    }

    @Override
    public String id() {
        return amMessageBase.id();
    }

    @Override
    public String name() {
        return amMessageBase.name();
    }

    @Override
    public String subject() {
        return amMessageBase.subject();
    }

    @Override
    public byte[] body() {
        return amMessageBase.body();
    }

    @Override
    public Date sentAt() {
        return amMessageBase.sentAt();
    }

    @Override
    public Map<String, Objects> metadata() {
        return amMessageBase.metadata();
    }
}
