package sykros.cloud.edacore.internal.am.reply;

import com.fasterxml.jackson.databind.ObjectMapper;
import sykros.cloud.edacore.internal.am.Message;
import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.ddd.Reply;

public class ReplyPublisherBase implements ReplyPublisher {
    public static final String REPLY_PUBLISH_CHANNEL = "reply.publish";
    MessagePublisher messagePublisher;
    public ReplyPublisherBase(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }
    @Override
    public void Publish(String topic, Reply reply) throws Exception {
        Message replyMessage = new Message(reply.ReplyName());
        ObjectMapper mapper = new ObjectMapper();
        byte[] payload = mapper.writeValueAsBytes(reply.Payload());
        replyMessage.setSubject(topic);
        replyMessage.setSentAt(reply.OccurredOn());
        replyMessage.setData(payload);
        messagePublisher.Publish(topic, replyMessage);
    }
}
