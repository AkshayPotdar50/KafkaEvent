package com.example.realtime.kafka.kafka;

import com.example.realtime.kafka.model.TrackingEvent;
import com.example.realtime.kafka.service.TrackingService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final TrackingService trackingService;
    private final SimpMessagingTemplate messagingTemplate;

    public KafkaConsumerService(TrackingService trackingService, SimpMessagingTemplate messagingTemplate) {
        this.trackingService = trackingService;
        this.messagingTemplate = messagingTemplate;
    }


    @KafkaListener(topics = "tracking_updates", groupId = "tracking_group", containerFactory = "kafkaListenerContainerFactory")
    public void consumeTrackingUpdate(TrackingEvent event){
        trackingService.updateTracking(event);
        messagingTemplate.convertAndSend("/topic/tracking/" +event.getConsignmentId(), event);
    }
}
