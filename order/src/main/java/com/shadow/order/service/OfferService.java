package com.shadow.order.service;

import com.shadow.order.client.OfferClient;
import com.shadow.order.config.ModelMapperConfig;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.PedidoRepository;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OfferService {

    @Autowired
    private OfferClient offerClient;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapperConfig modelMapperConfig;
    @Autowired
    private ModelMapper modelMapper;

    public PedidoDtoResponse save(PedidoDtoRequest pedidoDtoRequest){
        Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
        pedidoRepository.save(pedido);
        return modelMapper.map(pedido, PedidoDtoResponse.class);
    }





    //service que chama o client
    //service que chama o repository
    //só quando necessário, of course
    //1. cria pedido. antes de salvar, chamar http,

}
