package com.shadow.order.service;

import com.shadow.order.domain.models.Offer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shadow.order.advice.exception.OrderException;
import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.PedidoRepository;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class PedidoService {

    @Autowired
    private OfferClient offerClient;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductClient productClient;

    public PedidoDtoResponse save(PedidoDtoRequest pedidoDtoRequest){
            Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
            pedidoRepository.save(pedido);
            return modelMapper.map(pedido, PedidoDtoResponse.class);
    }

    public PedidoDtoResponse getById(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new OrderException("Resource with id: " + id + "not found"));
        return modelMapper.map(pedido, PedidoDtoResponse.class);
    }




}