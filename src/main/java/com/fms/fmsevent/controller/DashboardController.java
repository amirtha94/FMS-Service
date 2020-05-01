package com.fms.fmsevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.fmsevent.model.Dashboard;
import com.fms.fmsevent.model.Events;

import reactor.core.publisher.Flux;

@RestController
public class DashboardController {

	@Autowired
	private WebClient.Builder webclient;
	
	@GetMapping("/getDashBoard")
	@PreAuthorize("hasRole('PMO') OR hasRole('ADMIN') OR hasRole('POC')")
	public Flux<Dashboard> fetchDashboard() {
		
		return webclient.build().get().uri("http://fms-events/event/getDashboardInfo")
				.retrieve()
				.bodyToFlux(Dashboard.class).log("Dashboard data");
	}
	
	@GetMapping("/getEvents")
	@PreAuthorize("hasRole('PMO') OR hasRole('ADMIN') OR hasRole('POC')")
	public Flux<Events> fetchAllEvents() {
		
		return webclient.build().get().uri("http://fms-events/event/allevents")
				.retrieve()
				.bodyToFlux(Events.class).log("Events data");
	}
}
