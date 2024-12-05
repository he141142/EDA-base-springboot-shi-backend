package sykros.cloud.edacore.internal.am;

import sykros.cloud.edacore.internal.ddd.Entity;

import java.util.Date;
import java.util.Map;

// Message Base containing the subject, title, timer, id. sent at (fired)
public interface IMessageBase extends Entity {
    String Subject();

    Map<String,Object> Metadata();

    Date SentAt();
}
