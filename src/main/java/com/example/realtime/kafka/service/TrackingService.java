package com.example.realtime.kafka.service;

import com.example.realtime.kafka.model.TrackingEvent;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TrackingService {

    private final ConcurrentHashMap<String, TrackingEvent> trackingData= new ConcurrentHashMap<>();

    public void updateTracking(TrackingEvent event){
        trackingData.put(event.getConsignmentId(), event);
    }

    public TrackingEvent getTracking(String consignmentId){
        return trackingData.get(consignmentId);
    }
}
