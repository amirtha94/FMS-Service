package com.fms.fmsevent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import reactor.core.publisher.Flux;

@ControllerAdvice
public class ExceptionMapping {

	
	@ExceptionHandler(value = ServerError.class)
	public Flux<ResponseEntity<Object>> exception(ServerError e) {
		return Flux.just(new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR));
	}
}
