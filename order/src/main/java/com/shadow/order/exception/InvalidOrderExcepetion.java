package com.shadow.order.exception;

public class InvalidOrderExcepetion extends RuntimeException {

	private static final long serialVersionUID = 8857758950933747662L;
	
	public InvalidOrderExcepetion(String msg) {
		super(msg);
	}

}
