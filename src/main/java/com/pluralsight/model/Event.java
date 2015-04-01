package com.pluralsight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="events")
public class Event {
	
	public static final String FIND_ALL_EVENTS = "findAllEvents";
	public static final String FIND_EVENT_REPORTS = "findEventReports";
	
	@Id
	@GeneratedValue
	@Column(name="EVENT_ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
