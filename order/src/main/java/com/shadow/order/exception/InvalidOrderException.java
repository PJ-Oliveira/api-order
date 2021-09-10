package com.shadow.order.exception;

public class InvalidOrderException extends RuntimeException {

	private static final long serialVersionUID = 8857758950933747662L;
	
	public InvalidOrderException (String msg) {
		super(msg);
	}

}
