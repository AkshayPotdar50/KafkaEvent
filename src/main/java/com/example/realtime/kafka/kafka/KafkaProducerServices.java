package com.example.realtime.kafka.kafka;

import com.example.realtime.kafka.model.TrackingEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServices {

    private final KafkaTemplate<String, TrackingEvent> kafkaTemplate;

    public KafkaProducerServices(KafkaTemplate<String, TrackingEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTrackingUpdate(TrackingEvent event){
        kafkaTemplate.send("tracking updates", event.getConsignmentId(),event);
    }
}
