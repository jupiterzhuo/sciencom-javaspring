package com.sciencom.springrestfulexample.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sciencom.springrestfulexample.response.ErrorMessageResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleExceptionInternal
	(Exception ex, WebRequest request) {
		
		//Hanya Get error Message 
		String errorMessageDescription = ex.getMessage();
		if(errorMessageDescription==null) {
			errorMessageDescription = ex.toString();
		}
		//Encapsulate Exception dengan class ErrorMessageResponse
		ErrorMessageResponse errResponse = 
				new ErrorMessageResponse(new Date(), errorMessageDescription);
		
		
		return new ResponseEntity<>(errResponse, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//spesific error handle
	@ExceptionHandler(value = {
			ArithmeticException.class,
			UserServiceException.class
			})
	public ResponseEntity<Object> handleSpesificException
	(Exception ex, WebRequest request) {
		
		//Hanya Get error Message 
		String errorMessageDescription = ex.getMessage();
		if(errorMessageDescription==null) {
			errorMessageDescription = ex.toString();
		}
		//Encapsulate Exception dengan class ErrorMessageResponse
		ErrorMessageResponse errResponse = 
				new ErrorMessageResponse(new Date(), errorMessageDescription);
		
		
		return new ResponseEntity<>(errResponse, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
