package com.fms.fmsevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.fmsevent.exception.ServerError;
import com.fms.fmsevent.model.FeedbackQuestion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

	 @Autowired
	// @LoadBalanced
	private WebClient.Builder webclient;

	/*
	 * @Bean //@LoadBalanced public WebClient.Builder webclient() { return
	 * WebClient.builder(); }
	 */

	/*
	 * @Autowired FeignServiceProxy feignService;
	 */
	@PostMapping("/feedbackData")
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<FeedbackQuestion> insertFeedback(@RequestBody FeedbackQuestion feedback) {
		Mono<FeedbackQuestion> feedBackData = Mono.just(feedback);
		return webclient.build().post().uri("http://localhost:8083/feedback").body(feedBackData, FeedbackQuestion.class)
				.retrieve().onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ServerError()))
				.bodyToMono(FeedbackQuestion.class).log("post data");
	}

	@GetMapping("/feedbackData")
	@PreAuthorize("hasRole('ADMIN')")
	public Flux<FeedbackQuestion> fetchAllFeedback() {
		// Flux<FeedbackQuestion> feed =feignService.getConvertValue();
		//fms-feedback-service
		return webclient.build().get().uri("http://localhost:8083/feedback").retrieve()
				.onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ServerError()))
				.bodyToFlux(FeedbackQuestion.class).log("fetch data");
	}

	@DeleteMapping("/feedbackData")
	@PreAuthorize("hasRole('ADMIN')")
	public Mono<String> deleteFeedback(@RequestBody FeedbackQuestion feedback) {
		Mono<FeedbackQuestion> feedBackData = Mono.just(feedback);

		return webclient.build().method(HttpMethod.DELETE).uri("http://localhost:8083/feedback")
				.body(feedBackData, FeedbackQuestion.class).retrieve()
				.onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new ServerError()))
				.bodyToMono(String.class).log("Delete data");
	}

}
