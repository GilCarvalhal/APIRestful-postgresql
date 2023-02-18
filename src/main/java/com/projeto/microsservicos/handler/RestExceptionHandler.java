package com.projeto.microsservicos.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projeto.microsservicos.model.error.ErrorMessage;
import com.projeto.microsservicos.model.exception.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handlerResponseNotFoundException(ResourceNotFoundException ex) {

		ErrorMessage error = new ErrorMessage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
