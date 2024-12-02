package sykros.cloud.edacore.internal.am;

import java.util.Date;

public interface IIncomingMessage extends IMessageBase {
    Date ReceivedAt();
}
