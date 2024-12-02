package com.example.demo.handlers.domainhandlers;

import com.example.demo.domain.events.TeamCreated;
import com.fasterxml.jackson.databind.ObjectMapper;
import sykros.cloud.edacore.internal.am.event.EventPublisher;
import sykros.cloud.edacore.internal.ddd.event.EventHandler;
import sykros.cloud.edacore.internal.ddd.event.IEvent;

public class DomainHandler implements EventHandler<IEvent> {
  EventPublisher eventPublisher;

    @Override
    public void handle(IEvent event) throws Exception {

    }


    void handleTeamCreated(IEvent event) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(event.Payload());
        TeamCreated teamCreated = objectMapper.readValue(json, TeamCreated.class);

    }
}
