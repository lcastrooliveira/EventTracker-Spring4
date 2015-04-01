package com.pluralsight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluralsight.model.Event;

@Repository("eventRepository")
public interface EventRepository extends JpaRepository<Event, Long> {

}
