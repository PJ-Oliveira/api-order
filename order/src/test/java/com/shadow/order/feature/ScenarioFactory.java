package com.shadow.order.feature;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.domain.models.Product;

public class ScenarioFactory {
	

	public static Pedido newPedido() {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(1L);
		pedido.setItem(newItemList());
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setTotalPedido(newCalculo());
		return pedido;
		
	}
	
	public static Item newItem() {
		Item itens = new Item();
		itens.setIdItem(1L);
		itens.setIdOffer(1L);
		itens.setIdProduct(1L);
		itens.setNomeProduct("Anador");
		itens.setPrecoProduct(new BigDecimal(15.99));
		itens.setDesconto(new BigDecimal(1.89));
		return itens;
	}
	
	public static List<Item> newItemList(){
		List<Item> itens = new ArrayList<>();
		itens.add(newItem());
		return itens;
	}
	
	public static List<Pedido> newListPedido(){
		List<Pedido> pedidos = new ArrayList<>();
		pedidos.add(newPedido());
		return pedidos;
	}
	
	public static Optional<Pedido> newOptionalPedido(){
		Optional<Pedido> pedidoOptional = Optional.of(newPedido());
		return pedidoOptional;
	}
	
	public static PedidoDtoRequest newPedidoRequest() {
		return new PedidoDtoRequest();
	}
	
	public static PedidoDtoResponse newPedidoResponse() {
		PedidoDtoResponse pedidoResponse = new PedidoDtoResponse();
		pedidoResponse.setIdPedido(newPedido().getIdPedido());
		pedidoResponse.setDataPedido(LocalDateTime.now());
		pedidoResponse.setTotalPedido(newPedido().getTotalPedido());
		
		return new PedidoDtoResponse();
	}
	
	public static Product newProduct() {
		return new Product();
	}
	
	public static BigDecimal newCalculo() {
		var totalItem = BigDecimal.ZERO.setScale(2,RoundingMode.HALF_UP);
		Item item = newItem();
		totalItem = totalItem.add(item.getPrecoProduct().subtract(item.getDesconto()));
		return totalItem;
	}

}
