package com.shadow.order.exception;

public class InvalidOrderException extends RuntimeException{
	private static final long serialVersionUID = 5166788244092275772L;

	public InvalidOrderException (String msg) {
		super(msg);
	}

}
