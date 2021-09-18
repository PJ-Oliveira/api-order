package com.shadow.order.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.shadow.order.domain.models.Item;
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
