package sykros.cloud.edacore.internal.am.event;

import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.ddd.event.IEvent;

public class EventPublisherBase implements EventPublisher{

    MessagePublisher messagePublisher;
    @Override
    public void Publish(String topic, IEvent event) throws Exception {
        EventMessageBase eventMessage = new EventMessageBase(event.Name());
        eventMessage.setOccurredOn(event.OccurredOn());
        eventMessage.setPayload(event.Payload());
        messagePublisher.Publish(topic, eventMessage);
    }
}
