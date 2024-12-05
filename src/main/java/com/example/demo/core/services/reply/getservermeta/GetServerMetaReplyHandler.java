package com.example.demo.core.services.reply.getservermeta;

import sykros.cloud.edacore.internal.ddd.Reply;

public class GetServerMetaReplyHandler<Q extends ServerMeta> {
    Class<Q> clazz;
    public static final String REPLY_NAME = "GetServerMetaReply";

    public <T extends Reply> void HandleGetServerMeta(T reply) {
        System.out.println("Handling GetServerMeta reply");
        try {
            System.out.println(clazz.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
