package com.example.realtime.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic trackingTopic(){
        return new NewTopic("tracking updates", 1,(short)1);
    }
}
