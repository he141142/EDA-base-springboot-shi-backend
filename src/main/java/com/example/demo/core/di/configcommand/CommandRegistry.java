package com.example.demo.core.di.configcommand;

import com.example.demo.core.am.AmCommandHandler;
import com.example.demo.core.cqs.Command;
import com.example.demo.core.ddd.DDDCommandHandler;
import com.example.demo.core.services.commands.CommandHandlers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class CommandRegistry {
    @Bean
    @Order(3)
    CommandHandlers AppCommandHandlers() {
        return new CommandHandlers();
    }

    @Bean
    @Order(1)
    DDDCommandHandler<Command<?>> dddCommandHandlers(@Qualifier("AppCommandHandlers") CommandHandlers commandHandlers) {
        return commandHandlers;
    }

    AmCommandHandler amCommandHandler(@Qualifier("dddCommandHandlers") DDDCommandHandler<Command<?>> commandHandler) {
        return new AmCommandHandler(commandHandler);
    }
}
