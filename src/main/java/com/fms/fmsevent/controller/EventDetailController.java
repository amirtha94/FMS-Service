package com.fms.fmsevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.fmsevent.model.EventDetail;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EventDetailController {
	
	@Autowired
	private WebClient.Builder webclient;

	@PostMapping("/eventdetails")
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<EventDetail> insertEvents(@RequestBody EventDetail event) {
		Mono<EventDetail> eventData = Mono.just(event);
		return webclient.build().post().uri("http://fms-events/eventdetail/eventdata")
		.body(eventData, EventDetail.class)
		.retrieve()
		.bodyToMono(EventDetail.class).log("post data");
	}
	
	
	@GetMapping("/eventdetails")
	@PreAuthorize("hasRole('PMO') OR hasRole('ADMIN') OR hasRole('POC')")
	public Flux<EventDetail> fetchAllEvents() {
		
		return webclient.build().get().uri("http://fms-events/eventdetail/eventdata")
				.retrieve()
				.bodyToFlux(EventDetail.class).log("Get data");
	}
	
}
