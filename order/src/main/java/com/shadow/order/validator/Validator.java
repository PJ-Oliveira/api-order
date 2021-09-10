package com.shadow.order.validator;

import com.shadow.order.advice.exception.OrderInValidException;

public interface Validator <T> {
	
	public void validator(T object) throws OrderInValidException;

}
