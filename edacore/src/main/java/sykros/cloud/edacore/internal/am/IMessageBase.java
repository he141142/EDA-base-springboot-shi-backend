package sykros.cloud.edacore.internal.am;

import sykros.cloud.edacore.internal.ddd.Entity;

import java.util.Date;

// Message Base containing the subject, title, timer, id. sent at (fired)
public interface IMessageBase extends Entity {
    String Subject();

    Object Metadata();

    Date SentAt();
}
