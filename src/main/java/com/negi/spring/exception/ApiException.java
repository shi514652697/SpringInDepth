package com.negi.spring.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.negi.spring.model.ErrorResopseDto;

public class ApiException extends Exception{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiException.class);
	
	private final String code;
	private final String message;
	private final Exception exception;
	private final String moreInfo;
	private final HttpStatus status;
	private final ErrorResopseDto errorResponse;
	public static Logger getLogger() {
		return LOGGER;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public Exception getException() {
		return exception;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public ApiException(String code, String message, Exception exception, String moreInfo, HttpStatus status) {
		super();
		this.code = code;
		this.message = message;
		this.exception = exception;
		this.moreInfo = moreInfo;
		this.status = status;
		this.errorResponse= getErrorResponse(message,status);
	}
	public ErrorResopseDto getErrorResponse() {
		return errorResponse;
	}
	
	
	
	private ErrorResopseDto getErrorResponse(String message, HttpStatus code)
	{
		ErrorResopseDto error = new ErrorResopseDto(message,code);
		
		return error;
	}

}
