package com.example.demo.adapter.repo.jpa.models;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class EventID implements Serializable {
    private String streamId;
    private String streamName;
    private int streamVersion;

    // Default constructor
    public EventID() {}

    // Constructor with all fields
    public EventID(String streamId, String streamName, int streamVersion) {
        this.streamId = streamId;
        this.streamName = streamName;
        this.streamVersion = streamVersion;
    }

    // Getters, Setters, hashCode, and equals
    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public int getStreamVersion() {
        return streamVersion;
    }

    public void setStreamVersion(int streamVersion) {
        this.streamVersion = streamVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventID eventId = (EventID) o;
        return streamVersion == eventId.streamVersion &&
                Objects.equals(streamId, eventId.streamId) &&
                Objects.equals(streamName, eventId.streamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streamId, streamName, streamVersion);
    }
}
