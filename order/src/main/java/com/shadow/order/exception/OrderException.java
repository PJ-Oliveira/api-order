package com.shadow.order.exception;

public class OrderException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public OrderException(Object id){
        super("Resource with id: " + id + "not found");
    }
}
