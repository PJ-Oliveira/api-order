package com.shadow.order.exception;

public class ResourceNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFound(Object id){
        super("Resource with id: " + id + "not found");
    }
}
