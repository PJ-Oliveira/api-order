package com.shadow.order.validator;

import com.shadow.order.configuration.OfferClientConfig;
import com.shadow.order.domain.models.Item;
import com.shadow.order.domain.models.Offer;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidateOffer {

    @Autowired
    private OfferClientConfig offerClient;
    @Autowired
    private Validate validateProduct;

    public void validate(Pedido pedido) {
        List<Item> itemList = pedido.getItem();
        for (Item item : itemList) {
            if (item.getIdOffer() != null) {
                verifyIfOfferExist(pedido);
            }
            validateProduct.validator(pedido);
        }
    }

    public void verifyIfOfferExist(Pedido pedido) {
        List<Item> itemList = pedido.getItem();
        for (Item item : itemList) {
            if (item.getIdOffer() != null) {
                Optional<Offer> oneOffer = offerClient.verifyIfOfferExist(item.getIdOffer());
                if (oneOffer.isPresent()) {
                    validateProduct.validator(pedido);
                }
                else {
                    throw new InvalidOrderException("Invalid Order: Please, verify the Offer Id");
                }
            }
        }
    }
}
