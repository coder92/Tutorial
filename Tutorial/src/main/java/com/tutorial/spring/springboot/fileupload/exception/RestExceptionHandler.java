package com.tutorial.spring.springboot.fileupload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception){
		
		return new ResponseEntity<>("Exception Occured = "+exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = AuthenticationException.class)
	public ResponseEntity<Object> authenticationHandler(Exception exception){
		
		return new ResponseEntity<>("Exception Occured = "+exception, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
}
