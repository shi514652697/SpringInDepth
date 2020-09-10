package com.negi.spring.exception;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.negi.spring.model.ErrorResopseDto;


public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
 private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionHandler.class);
	 
	 @Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		 
		 String errorMessage= ex.getBindingResult().getAllErrors().stream().
				 map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
		 ErrorResopseDto error = new ErrorResopseDto( errorMessage, HttpStatus.BAD_REQUEST);
	
		 return handleExceptionInternal(ex, error, headers, status, request);
	}
	 
	 @ExceptionHandler(value=ApiException.class)
	 @ResponseBody
	 public ResponseEntity<ErrorResopseDto> handleApiException(ApiException ex)
	 {
		 ErrorResopseDto error = new ErrorResopseDto(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ErrorResopseDto>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		 
	 }
	 
	 
	 
	 @ExceptionHandler({ConstraintViolationException.class})
	 @ResponseBody
	 public ResponseEntity<ErrorResopseDto> handleConstraintViolation(ConstraintViolationException ex)
	 {
		 String errorMessage= ex.getConstraintViolations().stream().
				 map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
		 ErrorResopseDto error = new ErrorResopseDto( errorMessage, HttpStatus.BAD_REQUEST);
	
		 return new ResponseEntity<ErrorResopseDto>(error, HttpStatus.BAD_REQUEST);
		 
	 }

}
