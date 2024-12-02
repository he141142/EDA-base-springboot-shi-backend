package sykros.cloud.edacore.internal.ddd.event;

import sykros.cloud.edacore.internal.ddd.Entity;

import java.util.Date;

public interface IEvent extends Entity {
    public Object Payload();
    Date OccurredOn();
    Object Metadata();
}
