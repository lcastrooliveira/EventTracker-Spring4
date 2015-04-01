package com.pluralsight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pluralsight.model.Event;
import com.pluralsight.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String displayEventpage(@ModelAttribute("event") Event event) {
		return "event";
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String processEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		System.out.println(event);
		if(result.hasErrors()) {
			return "event";
		} else {
			eventService.save(event);			
		}
		return "redirect:getEvents.html";
	}
	
	@RequestMapping(value="/getEvents", method = RequestMethod.GET)
	public String showEventsPage(Model model) {
		List<Event> events = eventService.findAllEvents();
		model.addAttribute("events",events);
		return "getEvents";		
	}	
}
