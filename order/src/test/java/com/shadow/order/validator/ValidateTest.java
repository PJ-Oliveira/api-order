package com.shadow.order.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;


import java.util.Optional;


import static org.mockito.BDDMockito.given;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.shadow.order.configuration.ProductClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.domain.models.Product;
import com.shadow.order.exception.InvalidOrderException;
import com.shadow.order.feature.ScenarioFactory;
import com.shadow.order.service.PedidoService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ValidateTest {

	
	@InjectMocks
	private Validate validate;
	
	
	
	@Mock 
	ProductClientConfig productClientConfig;
	
	
	@Test
	public void validate_checkProductExistenceInTheProductMicroservice_ExpectecSuccess() {
		var pedido = ScenarioFactory.newPedido();
		var product = ScenarioFactory.newProduct();
		var item = ScenarioFactory.newItem();
			
			validate.validator(pedido);	
			when(productClientConfig.getById(item.getIdProduct())).thenReturn(product);

			verify(productClientConfig, times(1)).getById(product.getId());
		
			
	}
	
	@Test
	public void validate_checkNotProductExistenceInTheProductMicroservice_ExpectedThrownException() {
	
		
		
		
	}
	
	
		
}
