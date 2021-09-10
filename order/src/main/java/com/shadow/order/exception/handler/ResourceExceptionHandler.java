package com.shadow.order.exception.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shadow.order.exception.DatabaseException;
import com.shadow.order.exception.InvalidOrderException;
import com.shadow.order.exception.StandardError;


	@ControllerAdvice
	public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {	
		
		

		@ExceptionHandler(DatabaseException.class)
		public ResponseEntity<StandardError> resourceNotFound(DatabaseException e, HttpServletRequest request){
			String error = "Resource Not Found";
			HttpStatus status = HttpStatus.CONFLICT;
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
		
		@ExceptionHandler(InvalidOrderException.class)
		public ResponseEntity<StandardError> resourceNotFound(InvalidOrderException e, HttpServletRequest request){
			String error = "Bad Request";
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
}
