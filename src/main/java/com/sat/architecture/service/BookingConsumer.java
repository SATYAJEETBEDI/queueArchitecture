package com.sat.architecture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    @Autowired
    BookingService bookingService;

    @KafkaListener(topics = "booking-topic",groupId = "booking-group")
    public void processKafkaBooking(String bookingRequest){
        bookingService.handleBooking(bookingRequest);
    }
}
