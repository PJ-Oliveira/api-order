package com.shadow.order.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.repository.PedidoRepository;

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
	
	
	public PedidoDtoResponse save(Long idProduto, Long id,PedidoDtoRequest pedidoDtoRequest){
	    pedidoDtoRequest.setIdOffer(offerClient.getIdOffer(id));
	    pedidoDtoRequest.setIdProduct(productClient.getByIdProduct(idProduto));
	    Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
	    pedidoRepository.save(pedido);
	    return modelMapper.map(pedido, PedidoDtoResponse.class);
	}

}
