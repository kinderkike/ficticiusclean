package com.ficticiusclean.api.exceptionhandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleBindException(BindException e) {
		List<ApiError> mensagens = e.getBindingResult().getFieldErrors().stream().map(fieldError -> new ApiError(fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST)).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagens);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> tratarNegocioException(Exception e) {
		ApiError apiError = new ApiError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
	}

}