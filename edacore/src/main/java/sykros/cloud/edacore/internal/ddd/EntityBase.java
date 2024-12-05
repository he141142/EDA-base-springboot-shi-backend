package sykros.cloud.edacore.internal.ddd;

import java.util.UUID;

public abstract class EntityBase implements Entity{
    String id;
    String name;

    public EntityBase(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public EntityBase(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String ID() {
        return id;
    }

    @Override
    public String Name() {
        return name;
    }

    @Override
    public void SetID(String id) {
        this.id = id;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }
}
