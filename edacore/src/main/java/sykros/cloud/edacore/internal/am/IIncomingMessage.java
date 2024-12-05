package sykros.cloud.edacore.internal.am;

import java.util.Date;

// use for raw message, command message and event message
public interface IIncomingMessage extends IMessageBase {
    Date ReceivedAt();
    byte[] data();
}
