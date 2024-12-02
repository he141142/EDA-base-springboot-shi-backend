package sykros.cloud.edacore.internal.am.reply;

import sykros.cloud.edacore.internal.ddd.Reply;

public interface ReplyPublisher {
    void Publish(String topic, Reply reply) throws Exception;
}
