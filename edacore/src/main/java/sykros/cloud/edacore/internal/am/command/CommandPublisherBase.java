package sykros.cloud.edacore.internal.am.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import sykros.cloud.edacore.internal.am.Message;
import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.ddd.Command;

public class CommandPublisherBase implements CommandPublisher {

    MessagePublisher messagePublisher;

    public CommandPublisherBase(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    public void Publish(String topic, Command command) throws Exception {
        CommandMessageBase commandMessage = new CommandMessageBase(command.CommandName());
        commandMessage.setOccurredOn(command.OccurredOn());
        commandMessage.setPayload(command.Payload());
        Message msg = new Message(command.ID(), command.CommandName());
        msg.setSubject(topic);
        ObjectMapper mapper = new ObjectMapper();
        byte[] payload = mapper.writeValueAsBytes(command.Payload());
        msg.setData(payload);
        messagePublisher.Publish(topic, msg);
    }
}
