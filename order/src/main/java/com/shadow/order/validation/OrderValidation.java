package com.shadow.order.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.configuration.OfferClientConfig;
import com.shadow.order.configuration.ProductClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderExcepetion;

@Service
public class OrderValidation {
    @Autowired
    private OfferClientConfig offerClient;
    private ProductClientConfig productClientConfig;
    @Autowired
    private OfferClientConfig offerClientConfig;



    public void validator(Pedido pedido) throws InvalidOrderExcepetion {

        List<Item> itens = new ArrayList<>();
        itens = pedido.getItem();
        for (Item item : itens) {
            try {
                productClientConfig.getById(item.getIdProduct());
                offerClientConfig.findOneOffer(item.getIdOffer());
            } catch (RuntimeException runtimeException) {
                throw new InvalidOrderExcepetion("Pedido Inválido");
            }
        }

    }
}
