package com.pluralsight.service;

import java.util.List;

import com.pluralsight.model.Event;

public interface EventService {

	Event save(Event event);

	List<Event> findAllEvents();
	
	void delete(Event event);

}