package com.fms.fmsevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fms.fmsevent.model.User;
import com.fms.fmsevent.model.UserInfo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserInfoController {

	@Autowired
	private WebClient.Builder webclient;

	@PostMapping("/userInfo")
	public Mono<String> insertUserInfo(@RequestBody User userInfo) {
		Mono<User> userData = Mono.just(userInfo);
		return webclient.build().post().uri("http://fms-events/user/userInfo")
				.contentType(MediaType.APPLICATION_JSON).body(userData, User.class).retrieve().bodyToMono(String.class)
				.log("Post User info data");
	}

	@PreAuthorize("hasRole('PMO') OR hasRole('ADMIN')")
	@GetMapping("/userInfo")
	public Mono<UserInfo> fetchUserInfo(@RequestBody UserInfo userInfo) {
		Mono<UserInfo> userData = Mono.just(userInfo);
		return WebClient.builder().build().get().uri("http://fms-events/user/userInfo").retrieve()
				.bodyToMono(UserInfo.class).log("Post User info data");
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/userInfo/addpmo/{employeeId}")
	public Mono<Object> addPmoRole(@PathVariable String employeeId) {
		String role = "pmo";
		return WebClient.builder().build().put()
				.uri("http://localhost:8081/user/userInfo/changerole/{employeeId}/{role}",employeeId,role)
				.exchange()
				 .flatMap(clientResponse -> {
				     if (clientResponse.statusCode().is5xxServerError()) {
				        clientResponse.body((clientHttpResponse, context) -> {
				           return clientHttpResponse.getBody();
				        });
				     return clientResponse.bodyToMono(String.class);
				   }
				   else
				     return clientResponse.bodyToMono(String.class);
				});
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/userInfo/removepmo/{employeeId}")
	public Mono<Object> removePmoRole(@PathVariable String employeeId) {
		String role = "participant";
		return WebClient.builder().build().put()
				.uri("http://localhost:8081/user/userInfo/changerole/{employeeId}/{role}",employeeId,role)
				.exchange()
				 .flatMap(clientResponse -> {
				     if (clientResponse.statusCode().is5xxServerError()) {
				        clientResponse.body((clientHttpResponse, context) -> {
				           return clientHttpResponse.getBody();
				        });
				     return clientResponse.bodyToMono(String.class);
				   }
				   else
				     return clientResponse.bodyToMono(String.class);
				});
	}
}
