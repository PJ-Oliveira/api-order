package com.shadow.order.advice.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public OrderException(Object id){
        super();
    }
}
