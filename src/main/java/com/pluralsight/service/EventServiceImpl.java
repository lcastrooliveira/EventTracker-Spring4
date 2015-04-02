package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pluralsight.model.Event;
import com.pluralsight.repository.EventRepository;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	@Transactional
	public Event save(Event event) {		
		return eventRepository.save(event);
	}
	
	@Override
	public List<Event>findAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public void delete(Event event) {		
		eventRepository.delete(event);		
	}

	@Override
	public Event findById(Long id) {		
		return eventRepository.findOne(id);
	}
	
}
