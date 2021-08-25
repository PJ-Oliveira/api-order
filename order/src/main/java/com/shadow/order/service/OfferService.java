package com.shadow.order.service;


import com.shadow.order.domain.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface OfferService {

    public List<Object> getOffer();

    public List<Object> getOfferById(Long id);

    public List<Object> getOfferByDesconto(BigDecimal desconto);

    public List<Object> getProductByProduct(BigDecimal product);

    //Pensando
    /*public static List<Object> savePedidoById(Long id){
        double total = 0.0;
        Pedido pedido = new Pedido;
        return pedido;
    }*/
}
