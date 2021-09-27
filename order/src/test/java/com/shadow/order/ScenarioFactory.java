package com.shadow.order;

import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ScenarioFactory {

    public static Pedido newPedido(){
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1L);
        pedido.setItem(new ArrayList<Item>());
        pedido.setTotalPedido(BigDecimal.valueOf(2L));
        return pedido;
    }

    public static Item newItem(){
        Item item = new Item();
        item.setIdOffer(1L);
        item.setIdProduct(1L);
        item.setNomeProduct("Product");
        item.setValorTotalItem(BigDecimal.valueOf(2L));
        item.setPrecoProduct(BigDecimal.valueOf(2L));
        item.setDesconto(BigDecimal.valueOf(2L));
        item.setIdItem(1L);
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(item);
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1L);
        pedido.setItem(itemList);
        pedido.setTotalPedido(BigDecimal.valueOf(2L));
        return item;
    }

    public static Pedido newPedido2(){
        Item item = new Item();
        item.setIdOffer(1L);
        item.setIdProduct(1L);
        item.setNomeProduct("Product");
        item.setValorTotalItem(BigDecimal.valueOf(2L));
        item.setPrecoProduct(BigDecimal.valueOf(2L));
        item.setDesconto(BigDecimal.valueOf(2L));
        item.setIdItem(1L);
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList.add(item);
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1L);
        pedido.setItem(itemList);
        pedido.setTotalPedido(BigDecimal.valueOf(2L));
        return pedido;
    }








}
