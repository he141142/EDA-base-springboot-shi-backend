package sykros.cloud.edacore.internal.am.reply;

import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.ddd.Reply;

public class ReplyPublisherBase implements ReplyPublisher {

    MessagePublisher messagePublisher;

    @Override
    public void Publish(String topic, Reply reply) throws Exception {
        ReplyMessageBase replyMessage = new ReplyMessageBase(reply.ReplyName());
        replyMessage.setOccurredOn(reply.OccurredOn());
        replyMessage.setPayload(reply.Payload());
        messagePublisher.Publish(topic, replyMessage);
    }
}
