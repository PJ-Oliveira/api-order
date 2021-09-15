package com.shadow.order.exception.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

		/*@ExceptionHandler(InvalidOrderExcepetion.class)
		public ResponseEntity<StandardError> resourceNotFound(InvalidOrderExcepetion e, HttpServletRequest request){
			String error = "Bad Request";
			HttpStatus status = HttpStatus.BAD_REQUEST;
			StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
			return ResponseEntity.status(status).body(err);
		}*/
}
