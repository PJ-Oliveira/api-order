package com.shadow.order.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.PedidoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value = "/order")
@RequiredArgsConstructor
public class PedidoController {
	
    @Autowired
    private final PedidoService pedidoService;

    @Transactional
    @PostMapping
    @ApiOperation(value = "Realiza cadastro de pedidos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<PedidoDtoResponse> create(@Valid @RequestBody PedidoDtoRequest pedidoDtoRequest){
        PedidoDtoResponse pedidoDtoResponse = pedidoService.save(pedidoDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(pedidoDtoResponse.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(pedidoDtoResponse);
    }
    
    
    @GetMapping
    @ApiOperation(value = "Realiza exibição de todos os pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 500, message = "Sistema indisponivel")})
    public ResponseEntity<List<PedidoDtoResponse>> findAll(){
    	List<PedidoDtoResponse> pedidoResponse = pedidoService.getAll();
    	return ResponseEntity.ok().body(pedidoResponse);
    }    

}