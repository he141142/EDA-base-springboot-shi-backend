package sykros.cloud.edacore.internal.es;

public interface IVersioner {
    void SetVersion(int version);
    int PendingVersion();
    int CurrentVersion();
}
