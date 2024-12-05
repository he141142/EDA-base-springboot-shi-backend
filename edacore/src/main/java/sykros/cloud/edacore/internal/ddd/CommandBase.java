package sykros.cloud.edacore.internal.ddd;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public abstract class CommandBase extends EntityBase implements Command{
    public CommandBase(String id, String name) {
        super(id, name);
    }

    @Setter
    @Getter
    protected Object payload;

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase(String name, Object payload) {
        super(name);
        this.payload = payload;
    }

    @Override
    public String CommandName() {
        return this.Name();
    }

    @Override
    public Object Payload() {
        return payload;
    }

    @Override
    public Object Metadata() {
        return null;
    }

    @Override
    public Date OccurredOn() {
        return null;
    }
}
