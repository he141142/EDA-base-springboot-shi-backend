package sykros.cloud.edacore.internal.am.event;

import com.fasterxml.jackson.databind.json.JsonMapper;
import sykros.cloud.edacore.internal.am.Message;
import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.ddd.event.IEvent;

public class EventPublisherBase implements EventPublisher{

    MessagePublisher messagePublisher;
    @Override
    public void Publish(String topic, IEvent event) throws Exception {

        Message message = new Message(event.ID(), event.Name());
        message.setSentAt(event.OccurredOn());
        message.setSubject(topic);

        JsonMapper mapper = new JsonMapper();
        byte[] payload = mapper.writeValueAsBytes(event.Payload());
        message.setData(payload);

        messagePublisher.Publish(topic, message);
    }
}
