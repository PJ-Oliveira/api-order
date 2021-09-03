package com.shadow.order.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

<<<<<<< HEAD
import com.shadow.order.client.OfferClient;
import com.shadow.order.domain.dto.dtorequest.ItemDtoRequest;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.ItemDtoResponse;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.domain.models.Offer;
import com.shadow.order.service.ItemService;
import com.shadow.order.service.PedidoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
=======
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb


@RestController
@RequestMapping("/order")
public class PedidoController {
	
	
	@Autowired
<<<<<<< HEAD
	private ItemService itemService;

    @Autowired
    private OfferClient offerClient;
   
   

=======
	private final ProductClient productClient;
    @Autowired
    private final OfferClient offerClient;
    @Autowired
    private final PedidoService pedidoService;



    @Transactional
    @PostMapping
    @ApiOperation(tags = {"Cadastro"}, value="Cadastro de Pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<PedidoDtoResponse> create(@Valid @RequestBody PedidoDtoRequest pedidoDtoRequest){
        PedidoDtoResponse pedidoDtoResponse = pedidoService.save(pedidoDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(pedidoDtoResponse.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(pedidoDtoResponse);
    }


    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable Long id){
>>>>>>> 18234e2a9fc6ef2d36b501dd75da48cdbfd0b9cb


   


    @GetMapping("/oferta/{id}")
    public Offer getOffer(@PathVariable Long id){

        return offerClient.getById(id);
    }

    
    

}