package com.example.demo.adapter.repo.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Entity
@Setter
@Table(name = "events")
@IdClass(EventID.class)
public class Event {

    // Getters and Setters
    @Id
    @Column(name = "stream_id", nullable = false)
    private String streamId;

    @Id
    @Column(name = "stream_name", nullable = false)
    private String streamName;

    @Id
    @Column(name = "stream_version", nullable = false)
    private int streamVersion;

    @Column(name = "event_id", nullable = false)
    private String eventId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Lob
    @Column(name = "event_data", nullable = false)
    private byte[] eventData;

    @Column(name = "occurred_at", nullable = false)
    private Instant occurredAt;

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public void setStreamVersion(int streamVersion) {
        this.streamVersion = streamVersion;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventData(byte[] eventData) {
        this.eventData = eventData;
    }

    public void setOccurredAt(Instant occurredAt) {
        this.occurredAt = occurredAt;
    }
}
