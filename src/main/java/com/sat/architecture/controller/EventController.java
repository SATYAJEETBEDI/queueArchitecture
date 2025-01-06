package com.sat.architecture.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sat.architecture.config.Event;
import com.sat.architecture.repository.EventRepo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private  EventRepo eventRepo;

    @PostMapping("/")
    public ResponseEntity<Map<String,String>> userEntry(@RequestBody Event event) {
        eventRepo.save(event);
        Map<String,String> response = new HashMap<>();
        response.put("message", "event added");
        return ResponseEntity.ok(response);
    }
    
}
