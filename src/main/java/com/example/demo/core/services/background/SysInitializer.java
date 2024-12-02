package com.example.demo.core.services.background;

import com.example.demo.core.am.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SysInitializer implements Runnable {
    private static final String DEFAULT_TOPIC = "com.sykros.am.command";
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SysInitializer.class);
    MessageSubscriber messageSubscriber;

    MessageHandler messageHandler;

    @Autowired
    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @Autowired
    @Qualifier("KafkaMessageSubscriber")
    public void setMessageSubscriber(MessageSubscriber messageSubscriber) {
        logger.info("Setting MessageSubscriber");
        this.messageSubscriber = messageSubscriber;
    }

    @Override
    public void run() {
       this.messageSubscriber.Subscribe("drake",messageHandler, SubscriberOption.builder().name("sykros.command").build());
    }
}
