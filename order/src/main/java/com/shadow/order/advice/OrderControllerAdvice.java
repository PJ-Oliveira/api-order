package com.shadow.order.advice;

import com.shadow.order.advice.exception.OrderException;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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