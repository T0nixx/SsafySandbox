package com.ssafy.sandbox.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.sandbox.exception.dto.ModelNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ModelNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleModelNotFoundException(ModelNotFoundException exception) {
		return ResponseEntity
			.badRequest()
			.body(new ErrorResponse(exception.getMessage()));
	}
}
