package sykros.cloud.edacore.internal.ddd;

import java.util.Date;
import java.util.Map;

public interface Reply
{
    String ReplyName();
    Object Payload();
    Map<String,Object> Metadata();
    Date OccurredOn();
}
