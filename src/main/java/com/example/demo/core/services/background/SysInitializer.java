package com.example.demo.core.services.background;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import sykros.cloud.edacore.internal.am.MessageHandler;
import sykros.cloud.edacore.internal.am.MessageSubscriber;
import sykros.cloud.edacore.internal.am.SubscriberConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class SysInitializer implements Runnable {
    private static final String DEFAULT_TOPIC = "com.sykros.am.command";
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SysInitializer.class);
    MessageSubscriber messageSubscriber;
    MessageHandler commandHandler;

    MessageHandler replyHandler;

    @Autowired
    public void setCommandHandler(@Qualifier("CommandMessageHandler") MessageHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Autowired
    public void setReplyHandler(@Qualifier("ReplyMessageHandler") MessageHandler replyHandler) {
        this.replyHandler = replyHandler;
    }

    @Autowired
    @Qualifier("KafkaMessageSubscriber")
    public void setMessageSubscriber(MessageSubscriber messageSubscriber) {
        logger.info("Setting MessageSubscriber");
        this.messageSubscriber = messageSubscriber;
    }

    @Override
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            try {
                this.messageSubscriber.Subscribe("drake.command", commandHandler, SubscriberConfig.builder().name("sykros.command").build());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        executor.submit(() -> {
            try {
                this.messageSubscriber.Subscribe("drake.reply", replyHandler, SubscriberConfig.builder().name("sykros.reply").build());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
        logger.info("SysInitializer started");
        logger.info("executor shutdown");
    }
}
