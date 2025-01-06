package com.sat.architecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sat.architecture.config.Event;

public interface EventRepo extends JpaRepository<Event,Long> {

    
}
