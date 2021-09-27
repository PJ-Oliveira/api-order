package com.shadow.order.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.shadow.order.feature.ScenarioFactory;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CalcularPedidoTest {
	
	@InjectMocks
	private CalcularPedido calcularPedido;
	
	
	

	@Test
	public void calcularPedido_calculateOrderValue_ExpectedSucess() {
		var pedido = ScenarioFactory.newPedido();
		var calculo = ScenarioFactory.newCalculo();
		var totalItem = BigDecimal.ZERO.setScale(2,RoundingMode.HALF_UP);
		var totalPedido = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
		calcularPedido.calcularPedido(pedido);
		
		totalItem = totalItem.add(calculo);
		totalPedido = totalPedido.add(totalItem).setScale(2,RoundingMode.HALF_UP);
		
		assertEquals(new BigDecimal(14.10).setScale(2,RoundingMode.HALF_UP), totalPedido);
		
		
	}

}
