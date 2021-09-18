package com.shadow.order.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;

@Service
public class CalcularPedido {
	
	public void calcularPedido(Pedido pedido) {
		var valorTotalPedido = BigDecimal.ZERO.setScale(2,RoundingMode.HALF_UP);
		List<Item> itens = pedido.getItem();
		for (Item item : itens) {
			var valorTotalItem = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
			valorTotalItem = valorTotalItem.add(item.getPrecoProduct().subtract(item.getDesconto()));
			valorTotalPedido =valorTotalPedido.add(valorTotalItem);
	
			item.setValorTotalItem(valorTotalItem); 
			pedido.setTotalPedido(valorTotalPedido);
		}
	}
	
	
	
	

}
