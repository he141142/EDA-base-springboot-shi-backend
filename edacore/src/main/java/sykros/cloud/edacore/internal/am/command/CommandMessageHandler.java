package sykros.cloud.edacore.internal.am.command;

import sykros.cloud.edacore.internal.am.IIncomingMessage;
import sykros.cloud.edacore.internal.am.MessageHandler;
import sykros.cloud.edacore.internal.am.reply.ReplyPublisher;
import sykros.cloud.edacore.internal.ddd.Command;
import sykros.cloud.edacore.internal.ddd.DDDCommandHandler;

import java.util.Date;

public class CommandMessageHandler implements MessageHandler {
    DDDCommandHandler<Command> dddCommandHandler;
    ReplyPublisher replyPublisher;

    public CommandMessageHandler(ReplyPublisher replyPublisher, DDDCommandHandler<Command> dddCommandHandler) {
        this.replyPublisher = replyPublisher;
        this.dddCommandHandler = dddCommandHandler;
    }

    @Override
    public void HandleMessage(IIncomingMessage iIncomingMessage) throws Exception {
        InComingCommandMessage commandMessage = new InComingCommandMessage(iIncomingMessage.Name());
        commandMessage.setOccurredOn(new Date());
        commandMessage.setPayload(iIncomingMessage.data());
        var metadata = iIncomingMessage.Metadata();
        String replyTo = null;
        if (metadata != null) {
            if (metadata.containsKey("ReplyTo")) {
                replyTo = (String) metadata.get("ReplyTo");
            }
        }
        var reply = dddCommandHandler.HandleCommand(commandMessage);
    }
}
