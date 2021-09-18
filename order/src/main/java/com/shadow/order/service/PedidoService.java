package com.shadow.order.service;
<<<<<<< HEAD


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

=======
import com.shadow.order.advice.OrderControllerAdvice;
import com.shadow.order.repository.ItemRepository;
>>>>>>> 9ad3c50 (Atualizações)
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Pedido;
import com.shadow.order.exception.InvalidOrderException;
import com.shadow.order.exception.ResourceNotFoundException;
import com.shadow.order.repository.PedidoRepository;
import com.shadow.order.util.CalcularPedido;
import com.shadow.order.validator.Validate;






@Service
public class PedidoService {

<<<<<<< HEAD
=======
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
    

    public PedidoDtoResponse save(PedidoDtoRequest pedidoDtoRequest){
            Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
            pedido.getItem().stream()
                    .map(i -> i.getIdOffer()
                            .equals(offerClient.findOneOffer(i.getIdOffer())))
                    .collect(Collectors.toList());
                /*pedido.getItem().stream()
                .map(i -> i.getIdProduct().equals(productClient.getById(i.getIdProduct())))
                .collect(Collectors.toList());*/
            pedidoRepository.save(pedido);
            return modelMapper.map(pedido, PedidoDtoResponse.class);
>>>>>>> 9ad3c50 (Atualizações)


	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Validate validateProduct;
	@Autowired
	private CalcularPedido calcularPedido;
	

	@Transactional
	public PedidoDtoResponse save(PedidoDtoRequest pedidoDtoRequest){
		Pedido pedido = modelMapper.map(pedidoDtoRequest, Pedido.class);
		validateProduct.validator(pedido);
		calcularPedido.calcularPedido(pedido);
		pedidoRepository.save(pedido);
		return modelMapper.map(pedido, PedidoDtoResponse.class);
	}

   
    public PedidoDtoResponse getById(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new InvalidOrderException("Resource with id: " + id + "not found"));
        return modelMapper.map(pedido, PedidoDtoResponse.class);
    }


	public List<PedidoDtoResponse> getAll() {
		List<Pedido> pedido = pedidoRepository.findAll();
		return pedido.stream()
				.map(p -> modelMapper
						.map(p, PedidoDtoResponse.class))
				.collect(Collectors.toList());

	}
	
	public PedidoDtoResponse findById(Long id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource not found " + id ));
		return modelMapper.map(pedido, PedidoDtoResponse.class);
	}
	
	@Transactional
	public void delete(Long id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Resource not found: "+id));
		this.pedidoRepository.delete(pedido);
	}
	
	

}