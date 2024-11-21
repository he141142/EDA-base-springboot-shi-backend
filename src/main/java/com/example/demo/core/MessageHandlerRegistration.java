package com.example.demo.core;

import com.example.demo.core.am.AmCommandHandler;
import com.example.demo.core.am.MessageSubscriber;

public class MessageHandlerRegistration {
    public static final String COMMAND_SUBSCRIBER_KEY = "com.sykros.am.command";
    AmCommandHandler commandHandler;

    public MessageHandlerRegistration(AmCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void RegisterCommandHandlerTransaction(MessageSubscriber messageSubscriber) {
        messageSubscriber.Subscribe(COMMAND_SUBSCRIBER_KEY, commandHandler, null);
    }
}
