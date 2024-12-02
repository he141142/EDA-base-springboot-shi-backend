package sykros.cloud.edacore.internal.ddd;

public interface Entity {
    String ID();
    String Name();
    void SetID(String id);
    void SetName(String name);
}
