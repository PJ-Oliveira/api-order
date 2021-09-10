package com.shadow.order.validator;

import com.shadow.order.exception.InvalidOrderException;

public interface Validator <T> {
	
	public void validator(T object) throws InvalidOrderException;

}
