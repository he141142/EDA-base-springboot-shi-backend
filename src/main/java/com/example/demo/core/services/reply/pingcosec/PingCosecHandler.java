package com.example.demo.core.services.reply.pingcosec;

import sykros.cloud.edacore.internal.ddd.Reply;

public class PingCosecHandler<Q> {
    public static final String REPLY_NAME = "PingCosec";
    Class<Q> clazz;


    public <T extends Reply> void HandlePingCosec(T reply)  throws Exception{
        System.out.println("Handling PingCosec reply");
        try {
            System.out.println(clazz.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
