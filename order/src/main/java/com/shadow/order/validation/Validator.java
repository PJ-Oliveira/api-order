package com.shadow.order.validation;

import com.shadow.order.exception.InvalidOrderExcepetion;

public interface Validator <T> {
	
	public void validator(T object) throws InvalidOrderExcepetion;

}
