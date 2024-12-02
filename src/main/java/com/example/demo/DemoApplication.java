package com.example.demo;

import com.example.demo.core.services.background.SysInitializer;
import com.example.demo.infra.kafka.factories.SysConsumerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        SysInitializer sysInitializer = context.getBean(SysInitializer.class);
        var t1 = new Thread(sysInitializer);
        t1.start();
    }
}
