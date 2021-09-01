package com.shadow.order.advice;

import com.shadow.order.advice.exception.OrderException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OrderControllerAdvice
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler
            (value = { IllegalArgumentException.class, IllegalStateException.class, OrderException.class, Exception.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException runtimeException, WebRequest request) {
        return handleExceptionInternal(runtimeException, null,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}