package com.example.demo.adapter.kafka;


import lombok.Setter;
import sykros.cloud.edacore.internal.am.IIncomingMessage;
import sykros.cloud.edacore.internal.am.MessageBase;

import java.util.Date;

@Setter
public class KafkaIncomingMessage extends MessageBase implements IIncomingMessage {
    public KafkaIncomingMessage(String name) {
        super(name);
    }

    public KafkaIncomingMessage(String id, String name) {
        super(id, name);
    }

    Date receivedAt;
    byte[] data;


    @Override
    public Date ReceivedAt() {
        return receivedAt;
    }

    @Override
    public byte[] data() {
        return data;
    }

}
