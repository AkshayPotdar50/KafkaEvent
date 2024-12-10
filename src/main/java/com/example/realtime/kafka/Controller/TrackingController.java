package com.example.realtime.kafka.Controller;

import com.example.realtime.kafka.kafka.KafkaConsumerService;
import com.example.realtime.kafka.kafka.KafkaProducerServices;
import com.example.realtime.kafka.model.TrackingEvent;
import com.example.realtime.kafka.service.TrackingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final KafkaProducerServices kafkaProducerServices;
    private final TrackingService trackingService;


    public TrackingController(KafkaProducerServices kafkaProducerServices, TrackingService trackingService) {
        this.kafkaProducerServices = kafkaProducerServices;
        this.trackingService = trackingService;
    }

    @PostMapping("/update")
    public String updateTracking(@RequestBody TrackingEvent event){
        kafkaProducerServices.sendTrackingUpdate(event);
        return "Tracking update sent !";
    }


    @GetMapping("/{consignmentId}")
    public TrackingEvent getTracking(@PathVariable String consignmentId){
        return trackingService.getTracking(consignmentId);
    }

}
