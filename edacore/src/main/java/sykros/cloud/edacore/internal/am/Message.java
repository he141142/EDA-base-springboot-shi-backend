package sykros.cloud.edacore.internal.am;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message extends MessageBase implements IMessage {
    public Message(String id, String name) {
        super(id, name);
    }

    public Message(String name) {
        super(name);
    }

    byte[] data;

    @Override
    public byte[] Data() {
        return data;
    }
}
