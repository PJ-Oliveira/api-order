package com.shadow.order.advice.exception;

public class OrderInValidException extends RuntimeException {

	private static final long serialVersionUID = 8857758950933747662L;
	
	public OrderInValidException (String msg) {
		super(msg);
	}

}
