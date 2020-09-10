package com.negi.spring.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;


public class ErrorResopseDto  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message= null;
	private String status= null;
	private HttpStatus httpStatus=null;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErrorResopseDto(String message, HttpStatus status) {
		
		this.message = message;
		this.setHttpStatus(status);
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	

}
