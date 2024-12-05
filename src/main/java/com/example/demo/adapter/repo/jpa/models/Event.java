package com.example.demo.adapter.repo.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "events")
@IdClass(EventID.class)
public class Event {

    public static String TABLE_NAME = "events";

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
    private Date occurredAt;

}
