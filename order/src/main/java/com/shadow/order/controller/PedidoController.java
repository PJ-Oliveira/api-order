package com.shadow.order.controller;

import com.shadow.order.client.OfferClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;


@Validated
@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
@Api(tags = {"PEDIDO"}, value = "Controller PEDIDO")
public class PedidoController {

	@Autowired
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

    @GetMapping("{id}")
    @ApiOperation(httpMethod = "GET", notes = "Busque a pedido pelo seu respectivo ID",tags = {"Busque pelo ID"}, value="Encontre pedido por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<?> findOneOffer(@Valid @PathVariable long id){
        PedidoDtoResponse pedidoDtoResponse = pedidoService.getById(id);
        if(pedidoDtoResponse != null) {
            return ResponseEntity.ok().body(pedidoDtoResponse);
        } return ResponseEntity.ok().body("Offer Id ou Product id invalid");
    }

}