package com.fms.fmsevent.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.fmsevent.Repository.EventDetailsRepository;

@Service
public class EventDetailsServiceImpl {

	
	@Autowired
	EventDetailsRepository detailsRepo;
	
	public void all() {
	}
	
}
