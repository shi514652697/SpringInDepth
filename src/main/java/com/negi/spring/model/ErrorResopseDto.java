package com.negi.spring.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


public class ErrorResopseDto  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message= null;
	private String status= null;
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
	

}
