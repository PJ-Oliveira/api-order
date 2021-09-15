package com.shadow.order.validation;

import com.shadow.order.exception.InvalidOrderExcepetion;
import com.shadow.order.client.OfferClientConfig;
import com.shadow.order.client.ProductClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderValidation {
    @Autowired
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
