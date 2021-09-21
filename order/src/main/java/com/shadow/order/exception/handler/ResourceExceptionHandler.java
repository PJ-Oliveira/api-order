package com.shadow.order.exception.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shadow.order.exception.InvalidOrderException;
import com.shadow.order.exception.MessageError;
import com.shadow.order.exception.ResourceNotFoundException;
import com.shadow.order.exception.StandardError;


@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {	
		
		
		@ExceptionHandler(InvalidOrderException.class)
		public ResponseEntity<StandardError> resourceNotFoundProduct(InvalidOrderException e, HttpServletRequest request){
			String error = "Erro ao tentar salvar o pedido";
			HttpStatus status = HttpStatus.NOT_FOUND;
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
		@ExceptionHandler(ResourceNotFoundException.class)
		public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
			String error = "Not Found";
			HttpStatus status = HttpStatus.NOT_FOUND;
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}
		
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid
						(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
			
			List<String> details = new ArrayList<>();
			
			for(ObjectError error  : ex.getBindingResult().getAllErrors()) {
				details.add(error.getDefaultMessage());
			}
			String msgErro = "Erro de validação";
			MessageError messageError = new MessageError(msgErro, details);
			return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
		}
		
}
