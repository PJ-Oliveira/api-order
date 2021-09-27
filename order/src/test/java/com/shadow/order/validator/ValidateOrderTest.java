package com.shadow.order.validator;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.shadow.order.configuration.ProductClientConfig;
import com.shadow.order.feature.ScenarioFactory;
import com.shadow.order.util.CalcularPedido;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ValidateOrderTest {

	
	@InjectMocks
	private ValidateOrder validate;
	
	@Mock
	private CalcularPedido calcularPedido;
	
	@Mock 
	ProductClientConfig productClientConfig;
	
	
	@Test
	public void validate_checkProductExistenceInTheProductMicroservice_ExpectecSuccess() {
		var pedido = ScenarioFactory.newPedido();
		var product = ScenarioFactory.newProduct();
		var item = ScenarioFactory.newItem();
			
			validate.validator(pedido);	
			when(productClientConfig.findById(eq(item.getIdProduct()))).thenReturn(product);
			calcularPedido.calcularPedido(pedido);
			
			verify(productClientConfig, times(1)).findById(item.getIdProduct());
			
	}
	
}
