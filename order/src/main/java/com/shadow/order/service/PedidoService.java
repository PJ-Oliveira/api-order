package com.shadow.order.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.PedidoRepository;


@Service
public class PedidoService {

   
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductClient productClient;
	    

    public PedidoDtoResponse save(PedidoDtoRequest pedidoDtoRequest){
            Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
            pedido.getItem().stream()
            				.map(i -> i.getIdProduct().equals(productClient.getById(i.getIdProduct())))
            				.collect(Collectors.toList());
            pedidoRepository.save(pedido);
            return modelMapper.map(pedido, PedidoDtoResponse.class);
    }


}