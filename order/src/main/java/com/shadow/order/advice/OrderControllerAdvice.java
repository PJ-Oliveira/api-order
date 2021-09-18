package com.shadow.order.advice;

import java.lang.reflect.InvocationTargetException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.shadow.order.advice.exception.OrderException;



@ControllerAdvice
public class OrderControllerAdvice
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler
            (value = { IllegalArgumentException.class, IllegalStateException.class, OrderException.class, InvocationTargetException.class})
    protected ResponseEntity<Object> handleConflict(
            OrderException orderException, WebRequest request) {
        return handleExceptionInternal(orderException, "Order invalid due to Offer or Product Exception",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}