package sykros.cloud.edacore.internal.ddd;

import java.util.Date;

public interface Command extends Entity{
    String CommandName();
    Object Payload();
    Object Metadata();
    Date OccurredOn();
}
