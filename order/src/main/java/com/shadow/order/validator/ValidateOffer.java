package com.shadow.order.validator;

import com.shadow.order.configuration.OfferClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Offer;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderException;
import com.shadow.order.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidateOffer {

    @Autowired
    private OfferClientConfig offerClient;
    @Autowired
    private ValidateOrder validateOrder;

    public void validade(Pedido pedido) {
        List<Item> itemList = pedido.getItem();
        for (Item item : itemList) {
           
                verifyIfOfferExist(item.getIdOffer());
            
        }
        validateOrder.validator(pedido);
    }

    private void verifyIfOfferExist(Long id) {
            offerClient.findOneOffer(id);
            
            		 
            }
        
    }

