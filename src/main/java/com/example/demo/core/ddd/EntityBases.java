package com.example.demo.core.ddd;

public final class EntityBases implements Entity {
    private String id;
    private String name;

    public EntityBases(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String GetID() {
        return id;
    }

    @Override
    public void SetID(String id) {
        this.id = id;
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }
}
