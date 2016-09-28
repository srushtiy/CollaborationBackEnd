/*package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.EventDAO;
import com.niit.collaboration.model.Event;

@RestController
public class EventController {
	
	@Autowired
	EventDAO eventDAO;
	
	@Autowired
	Event event;
	
	@GetMapping("/events")
	public ResponseEntity<List <Event>> listAllEvents(){
		List<Event> eventlist = eventDAO.list();
		if (eventlist.isEmpty()){
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Event>>(eventlist, HttpStatus.OK);
	}

}
*/