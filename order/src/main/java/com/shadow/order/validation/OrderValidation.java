package com.shadow.order.validation;

import java.lang.reflect.Type;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.advice.exception.OrderException;
import com.shadow.order.configuration.OfferClientConfig;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Offer;
import com.shadow.order.domain.models.Pedido;

@Service
public class OrderValidation {

    @Autowired
    private OfferClientConfig offerClient;

    public PedidoDtoResponse validate(Pedido pedido){
        pedido.getItem().stream().map(i -> i.getIdOffer().equals(offerClient.findOneOffer(i.getIdOffer()))).collect(Collectors.toList());

        Offer offer = new Offer();
        if(offer != null){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(pedido, (Type) PedidoDtoResponse.class);
        }
        throw new OrderException();
    }

}
