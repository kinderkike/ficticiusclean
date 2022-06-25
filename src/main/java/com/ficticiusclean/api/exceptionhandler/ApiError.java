package com.ficticiusclean.api.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {
	
	private LocalDateTime timestamp;
	private int code;
	private HttpStatus status;
	private String message;

	public ApiError(String errorMessage, HttpStatus httpStatus) {
		this.timestamp = LocalDateTime.now();
		this.code = httpStatus.value();
		this.status = httpStatus;
		this.message = errorMessage;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
