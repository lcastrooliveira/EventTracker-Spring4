package com.pluralsight.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pluralsight.model.Event;
import com.pluralsight.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String displayEventpage(@ModelAttribute("event") Event event,Model model) {
		if(null!=event) model.addAttribute("event", event);
		System.out.println(event);
		return "event";
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String processEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {		
		if(result.hasErrors()) {
			System.out.println("Result has errors");			
		} else {
			System.out.println("post "+event);
			eventService.save(event);			
		}
		return "redirect:getEvents.html";
	}
	
	@RequestMapping(value="/getEvents", method = RequestMethod.GET)
	public String showEventsPage(Model model) {
		Event event = new Event();
		List<Event> events = eventService.findAllEvents();
		model.addAttribute("events",events);
		model.addAttribute("event", event);
		return "getEvents";		
	}
	
	@RequestMapping(value="removeEvent")
	public String removeEvent(Event event) {
		eventService.delete(event);		
		return "redirect:/getEvents.html";
	}
	
	@RequestMapping(value="editEvent")
	public String editEvent(Long id, Model model,RedirectAttributes redirectAttributes) {		
		System.out.println("INSIDE EDIT EVENT");
		//model.addAttribute("event",);
		redirectAttributes.addFlashAttribute("event", eventService.findById(id));
		return "redirect:/event.html";
	}
}
