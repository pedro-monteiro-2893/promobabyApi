package com.promobaby.promoBabyApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PromoBabyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInternalServerError(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PromoBabyApiException.class)
	public ResponseEntity<String> handleInternalServerError(PromoBabyApiException ex) {
		return new ResponseEntity<>(ex.getExternalMessage(),HttpStatus.INTERNAL_SERVER_ERROR );
	}

}
