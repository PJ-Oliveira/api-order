package com.shadow.order.service;
import com.shadow.order.advice.OrderControllerAdvice;
import com.shadow.order.repository.ItemRepository;
import com.shadow.order.validation.OrderValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shadow.order.advice.exception.OrderException;
import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.PedidoRepository;

import java.util.stream.Collectors;


@Service
public class PedidoService {

    @Autowired
    private OfferClient offerClient;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductClient productClient;
    @Autowired
    private OrderValidation orderValidation;

    

    public PedidoDtoResponse save(PedidoDtoRequest pedidoDtoRequest) {
        Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
        orderValidation.validate(pedido);
        pedidoRepository.save(pedido);
        return orderValidation.validate(pedido);
    }

    public PedidoDtoResponse getById(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new OrderException());
        return modelMapper.map(pedido, PedidoDtoResponse.class);
    }
}