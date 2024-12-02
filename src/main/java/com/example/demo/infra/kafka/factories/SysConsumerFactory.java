package com.example.demo.infra.kafka.factories;

import com.example.demo.core.am.AmInComingMessage;
import com.example.demo.core.am.SubscriberOption;
import com.example.demo.infra.kafka.config.ConsumerOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component
public class SysConsumerFactory {
    SysKafkaProperties kfProp;

    @Autowired
    public void setKfProp(SysKafkaProperties kfProp) {
        this.kfProp = kfProp;
    }


    private ConsumerFactory<String, Object> buildConsumerFactory(SubscriberOption subscriberOption) {
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
    public ConcurrentKafkaListenerContainerFactory<String, AmInComingMessage> CommandKafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, AmInComingMessage>();
        factory.setConsumerFactory(buildConsumerFactory(SubscriberOption.builder().name("sykros.command").build()));
        return factory;
    }
}
