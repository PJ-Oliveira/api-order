package com.shadow.order.advice;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

=======
import com.shadow.order.advice.exception.OrderException;
import org.hibernate.criterion.Order;
>>>>>>> 1be24e5 (Validação do Pedido pelo IdOffer)
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
<<<<<<< HEAD


=======
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 1be24e5 (Validação do Pedido pelo IdOffer)

@ControllerAdvice
public class OrderControllerAdvice
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler
<<<<<<< HEAD
            (value = { IllegalArgumentException.class, IllegalStateException.class})
=======
            (value = { IllegalArgumentException.class, IllegalStateException.class, OrderException.class, InvocationTargetException.class})
>>>>>>> 1be24e5 (Validação do Pedido pelo IdOffer)
    protected ResponseEntity<Object> handleConflict(
            OrderException orderException, WebRequest request) {
        return handleExceptionInternal(orderException, "Order invalid due to Offer or Product Exception",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}