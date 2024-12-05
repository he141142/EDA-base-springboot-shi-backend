package sykros.cloud.edacore.internal.ddd.reply;

import sykros.cloud.edacore.internal.ddd.Reply;

public interface ReplyHandler<T extends Reply> {
    void HandleReply(T reply) throws Exception;
}
