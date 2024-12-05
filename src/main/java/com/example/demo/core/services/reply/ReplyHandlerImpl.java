package com.example.demo.core.services.reply;

import com.example.demo.core.services.reply.getservermeta.GetServerMetaReplyHandler;
import com.example.demo.core.services.reply.getservermeta.ServerMeta;
import com.example.demo.core.services.reply.pingcosec.PingCosecHandler;
import com.example.demo.core.services.reply.pingcosec.PringCosec;
import sykros.cloud.edacore.internal.ddd.Reply;
import sykros.cloud.edacore.internal.ddd.reply.ReplyHandler;

public class ReplyHandlerImpl<T extends Reply> implements ReplyHandler<T> {
    @Override
    public void HandleReply(T reply) throws Exception {

        switch (reply.ReplyName()) {
            case GetServerMetaReplyHandler.REPLY_NAME -> HandleGetServerMeta(reply);
            case PingCosecHandler.REPLY_NAME -> HandlePingCosec(reply);
        }
    }


    private void HandlePingCosec(T reply) throws Exception {
        System.out.println("Handling CreateTeam reply");
        PingCosecHandler<PringCosec> handler = new PingCosecHandler<>();
        handler.HandlePingCosec(reply);
    }

    private void HandleGetServerMeta(T reply) throws Exception {
        System.out.println("Handling CreateTeam reply");
        GetServerMetaReplyHandler<ServerMeta> handler = new GetServerMetaReplyHandler<>();
        handler.HandleGetServerMeta(reply);
    }
}
