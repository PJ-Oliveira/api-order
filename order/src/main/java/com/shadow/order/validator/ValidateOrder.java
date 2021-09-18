package com.shadow.order.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.configuration.OfferClientConfig;
import com.shadow.order.configuration.ProductClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderException;

@Service
public class ValidateOrder {
    
	@Autowired
    private ProductClientConfig productClientConfig;
    @Autowired
    private OfferClientConfig offerClientConfig;



    public void validator(Pedido pedido)  {

        List<Item> itens = new ArrayList<>();
        itens = pedido.getItem();
        for (Item item : itens) {
            try {
                productClientConfig.getById(item.getIdProduct());
                offerClientConfig.findOneOffer(item.getIdOffer());
            } catch (RuntimeException runtimeException) {
                throw new InvalidOrderException("Pedido Inválido");
            }
        }

    }
}
