package com.sat.architecture.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer {
    
    private final KafkaTemplate<String,String> kafkaTemplate;

    public BookingProducer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }

    public void sendBookingRequest(String bookingrequest){
        kafkaTemplate.send("booking-topic",bookingrequest);
    }
}
