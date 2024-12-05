package com.example.demo.infra.kafka.factories;

import com.example.demo.infra.kafka.config.ConsumerOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;
import sykros.cloud.edacore.internal.am.IIncomingMessage;
import sykros.cloud.edacore.internal.am.SubscriberConfig;

import java.util.Map;
import java.util.Objects;

@Component
public class SysConsumerFactory {
    SysKafkaProperties kfProp;

    @Autowired
    public void setKfProp(SysKafkaProperties kfProp) {
        this.kfProp = kfProp;
    }


    private ConsumerFactory<String, Object> buildConsumerFactory(SubscriberConfig subscriberOption) {
        Map<String, Object> properties = kfProp.buildCommonProperties();
        ConsumerOption consumerOpt = kfProp.getConsumerConfig().get(subscriberOption.getName());
        assert consumerOpt != null;
        var opts = consumerOpt.buildProperty();
        opts.values().removeIf(Objects::isNull);
        System.out.println(opts);
        properties.putAll(opts);
        return new DefaultKafkaConsumerFactory<>(properties);
    }


    @Bean
    @Qualifier("CommandKafkaListenerContainerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, IIncomingMessage> CommandKafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, IIncomingMessage>();
        factory.setConsumerFactory(buildConsumerFactory(SubscriberConfig.builder().name("sykros.command").build()));
        return factory;
    }
}
