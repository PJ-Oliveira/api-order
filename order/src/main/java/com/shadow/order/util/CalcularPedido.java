package com.shadow.order.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;

@Service
public class CalcularPedido {

	
	public void somarPedido(Pedido pedido) {
		var valorTotalPedido = BigDecimal.ZERO.setScale(2,RoundingMode.HALF_UP);
		var valorTotalItem = BigDecimal.ZERO.setScale(2,RoundingMode.HALF_UP);
		List<Item> itens = pedido.getItem();
		for (Item item : itens) {
			valorTotalItem = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
			valorTotalPedido =valorTotalPedido.add(item.getPrecoProduct().subtract(item.getDesconto()));
			valorTotalItem = valorTotalItem.add(item.getPrecoProduct().subtract(item.getDesconto()));
			item.setValorTotalItem(valorTotalItem);
			pedido.setTotalPedido(valorTotalPedido);
		}
		
	}
	

	
	
	
}
