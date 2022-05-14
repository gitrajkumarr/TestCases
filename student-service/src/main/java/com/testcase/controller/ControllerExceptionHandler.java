package com.testcase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.testcase.customException.ResourceNotFoundException;
import com.testcase.model.ErrorMessage;


@ControllerAdvice
@ResponseStatus
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {ResourceNotFoundException.class})
	  public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	    HttpStatus.NOT_FOUND,
	        ex.getMessage(),
	        "Record not found");
	    
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	  }
}