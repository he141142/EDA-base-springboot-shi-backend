package sykros.cloud.edacore.internal.am.reply;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReplyData
{
    byte[] Payload;
    Date occurredOn;
}
