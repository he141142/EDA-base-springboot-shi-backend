package sykros.cloud.edacore.internal.ddd;

import java.util.Date;

public interface Reply
{
    String ReplyName();
    Object Payload();
    Object Metadata();
    Date OccurredOn();
}
