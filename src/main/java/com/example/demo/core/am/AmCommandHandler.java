package com.example.demo.core.am;

import com.example.demo.core.cqs.Command;
import com.example.demo.core.cqs.CommandBase;
import com.example.demo.core.ddd.DDDCommandHandler;
import org.springframework.stereotype.Component;


public class AmCommandHandler implements MessageHandler {
    public static final String AM_REPLY_PREFIX = "am.reply.";
    public static final String FAILURE = "Failure";
    public static final String SUCCESS = "Success";
    public static final String REPLY_CHANNEL_KEY = "com.sykros.am.replyChannel";

    //Example CommandHandlers implements DDDCommandHandler<Command<?>> is for all commands in the app (service)
    DDDCommandHandler<Command<?>> commandHandler;

    ReplyPublisher replyPublisher;

    public AmCommandHandler(DDDCommandHandler<Command<?>> commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void HandleMessage(AmInComingMessage message) throws Exception {
        CommandBase<?> command = new AmCommandMessage<>(message);
        String replyChannel = message.metadata().get(REPLY_CHANNEL_KEY).toString();
        AmReplyMessage replyMessage = null;
        try {
            replyMessage = commandHandler.Handle(command);
            replyPublisher.PublishMessage(onReply(replyMessage, SUCCESS), replyChannel);
        } catch (Exception e) {
            replyPublisher.PublishMessage(onReply(replyMessage, FAILURE), replyChannel);
        }
    }


    private AmReplyMessage onReply(AmReplyMessage msg, String replyType) {
        if (msg == null) {
            return null;
        }
        return switch (replyType) {
            case SUCCESS -> success(msg);
            case FAILURE -> failure(msg);
            default -> msg;
        };
    }

    private AmReplyMessage success(AmReplyMessage replyMessage) {
        replyMessage.setName(String.format("%s%s", AM_REPLY_PREFIX, SUCCESS));
        return replyMessage;
    }

    private AmReplyMessage failure(AmReplyMessage replyMessage) {
        replyMessage.setName(String.format("%s%s", AM_REPLY_PREFIX, FAILURE));
        return replyMessage;
    }
}
