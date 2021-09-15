package com.shadow.order.utils;

import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class SumRequest {

    public void sumPedido(Pedido pedido){
        var valorTotalPedido = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        List<Item> itens = pedido.getItem();
        for(Item item : itens){
            var valorTotalItem = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
            valorTotalPedido = valorTotalPedido.add(item.getPrecoProduct().subtract(item.getDesconto()));
            valorTotalItem = valorTotalItem.add(item.getPrecoProduct().subtract(item.getDesconto()));
            item.setTotalItens(valorTotalItem);
            pedido.setTotalPedido(valorTotalPedido);
        }


    }

}
