package sykros.cloud.edacore.internal.am.reply;

import com.fasterxml.jackson.databind.ObjectMapper;
import sykros.cloud.edacore.internal.am.IIncomingMessage;
import sykros.cloud.edacore.internal.am.MessageHandler;
import sykros.cloud.edacore.internal.ddd.Reply;
import sykros.cloud.edacore.internal.ddd.reply.ReplyHandler;

public class ReplyMessageHandler implements MessageHandler {
    ReplyHandler<Reply> replyReplyHandler;

    public ReplyMessageHandler(ReplyHandler<Reply> replyReplyHandler) {
        this.replyReplyHandler = replyReplyHandler;
    }

    @Override
    public void HandleMessage(IIncomingMessage iIncomingMessage) throws Exception {
        ReplyMessageBase replyMessage = new ReplyMessageBase(iIncomingMessage.ID(), iIncomingMessage.Name());
        iIncomingMessage.data();
        ObjectMapper mapper = new ObjectMapper();
        ReplyData replyData = mapper.readValue(iIncomingMessage.data(), ReplyData.class);
        replyMessage.setOccurredOn(replyData.getOccurredOn());
        replyMessage.setPayload(replyData.getPayload());
        replyReplyHandler.HandleReply(replyMessage);
    }
}
