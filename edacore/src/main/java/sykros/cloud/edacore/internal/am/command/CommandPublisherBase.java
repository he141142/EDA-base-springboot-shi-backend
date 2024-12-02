package sykros.cloud.edacore.internal.am.command;

import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.ddd.Command;

public class CommandPublisherBase implements CommandPublisher{

    MessagePublisher messagePublisher;

    public CommandPublisherBase(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void Publish(String topic, Command command) throws Exception {
        CommandMessageBase commandMessage = new CommandMessageBase(command.CommandName());
        commandMessage.setOccurredOn(command.OccurredOn());
        commandMessage.setPayload(command.Payload());
        messagePublisher.Publish(topic, commandMessage);
    }
}
