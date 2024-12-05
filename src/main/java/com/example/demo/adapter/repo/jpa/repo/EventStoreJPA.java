package com.example.demo.adapter.repo.jpa.repo;

import com.example.demo.adapter.repo.jpa.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventStoreJPA extends JpaRepository<Event, Long> {
    Optional<List<Event> >findAllByStreamIdAndStreamName(String streamId, String streamName);
    Optional<List<Event> >findAllByStreamIdAndStreamNameAndStreamVersionGreaterThan(String streamId, String streamName, int version);
    
}
