package sykros.cloud.edacore.internal.ddd;

import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Setter
public class ReplyBase extends  EntityBase implements Reply
{
    public static String REPLY_STATUS_SUCCESS = "success";
    public static String REPLY_STATUS_FAILURE = "failure";
    public static final String REPLY_STATUS_KEY = "status";
    public ReplyBase(String id, String name) {
        super(id, name);
    }

    public ReplyBase(String name) {
        super(name);
    }

    public void Failure(){
        if(metadata == null){
            metadata = new java.util.HashMap<>();
        }
        metadata.put(REPLY_STATUS_KEY, REPLY_STATUS_FAILURE);
    }

    public void Success(){
        if(metadata == null){
            metadata = new java.util.HashMap<>();
        }
        metadata.put(REPLY_STATUS_KEY, REPLY_STATUS_SUCCESS);
    }

    Object payload;
    Map<String,Object> metadata;
    Date occurredOn;

    @Override
    public String ReplyName() {
        return this.Name();
    }

    @Override
    public Object Payload() {
        return payload;
    }

    @Override
    public Map<String,Object> Metadata() {
        return metadata;
    }

    @Override
    public Date OccurredOn() {
        return occurredOn;
    }
}
