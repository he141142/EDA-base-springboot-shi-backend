package com.example.demo.di.handlers;


import com.example.demo.adapter.kafka.KafkaMessagePublisher;
import com.example.demo.core.services.commands.TeamCommandHandler;
import com.example.demo.core.services.reply.ReplyHandlerImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sykros.cloud.edacore.internal.am.MessagePublisher;
import sykros.cloud.edacore.internal.am.command.CommandMessageHandler;
import sykros.cloud.edacore.internal.am.reply.ReplyMessageHandler;
import sykros.cloud.edacore.internal.am.reply.ReplyPublisher;
import sykros.cloud.edacore.internal.am.reply.ReplyPublisherBase;
import sykros.cloud.edacore.internal.ddd.Command;
import sykros.cloud.edacore.internal.ddd.DDDCommandHandler;
import sykros.cloud.edacore.internal.ddd.Reply;
import sykros.cloud.edacore.internal.ddd.reply.ReplyHandler;

@Configuration
public class HandlerRegistration {

    @Bean
    @Qualifier("KafkaMessagePublisher")
    public MessagePublisher KafkaMessagePublisher() {
        return new KafkaMessagePublisher();
    }

    @Bean
    ReplyPublisher replyPublisher(@Qualifier("KafkaMessagePublisher") MessagePublisher messagePublisher) {
        return new ReplyPublisherBase(messagePublisher);
    }

    @Bean
    @Qualifier("TeamCommandHandler")
    DDDCommandHandler<Command> teamCommandHandler() {
        return new TeamCommandHandler<>();
    }

    @Bean
    @Qualifier("CommandMessageHandler")
    public CommandMessageHandler handler(
            ReplyPublisher replyPublisher,
            @Qualifier("TeamCommandHandler") DDDCommandHandler<Command> teamCommandHandler
    ) {
        return new CommandMessageHandler(replyPublisher, teamCommandHandler);
    }

    @Bean
    ReplyHandler<Reply> replyHandler() {
        return new ReplyHandlerImpl<>();
    }

    @Bean
    @Qualifier("ReplyMessageHandler")
    ReplyMessageHandler replyMessageHandler(ReplyHandler<Reply> replyHandler) {
        return new ReplyMessageHandler(replyHandler);
    }
}
