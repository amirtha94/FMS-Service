package com.fms.fmsevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.fmsevent.exception.ServerError;
import com.fms.fmsevent.model.EmailData;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private WebClient.Builder webclient;

	@GetMapping("/sendemail")
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<Void> sendEmailParticipants() {

		return webclient.build().get().uri("http://localhost:8083/email").retrieve()
        .bodyToMono(Void.class)
        .then();
	}


	@PostMapping("/sendemail")
	@PreAuthorize("hasRole('PMO') OR hasRole('ADMIN') OR hasRole('POC')")
	public Mono<String> sendEmailBu(@RequestBody EmailData data) {
		Mono<EmailData> emailData = Mono.just(data);
		return webclient.build().post().uri("http://localhost:8083/email")
		.body(emailData, EmailData.class)
		.retrieve().onStatus(HttpStatus::is5xxServerError, res -> Mono.error(new ServerError()))
		.bodyToMono(String.class).log("post data");
	}
}
