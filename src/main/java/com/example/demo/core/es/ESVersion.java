package com.example.demo.core.es;

public interface ESVersion {
    int Version();

    int PendingVersion();

    void SetVersion(int version);
}
