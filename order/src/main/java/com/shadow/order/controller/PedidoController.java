package com.shadow.order.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


@RestController
@RequestMapping(value = "/order")
public class PedidoController {
	
    @Autowired
    private  PedidoService pedidoService;

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
    @ApiOperation(value = "Exibe de todos os pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição bem sucedida"),
			@ApiResponse(code = 500, message = "Sistema indisponivel")})
    public ResponseEntity<List<PedidoDtoResponse>> findAll(){
    	List<PedidoDtoResponse> pedidoResponse = pedidoService.getAll();
    	return ResponseEntity.ok().body(pedidoResponse);
    }    
    
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Exibe um pedido informando um id válido")
   	@ApiResponses(value = {
   			@ApiResponse(code = 200, message = "Requisição bem sucedida"),
   			@ApiResponse(code = 404, message = "Recurso não encontrado"),
   			@ApiResponse(code = 500, message = "Sistema indisponivel")})
    public ResponseEntity<PedidoDtoResponse> findById(@PathVariable Long id){
    	PedidoDtoResponse pedidoResponse = pedidoService.findById(id);
    	return ResponseEntity.ok(pedidoResponse);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deletar um pedido informando um id válido")
   	@ApiResponses(value = {
   			@ApiResponse(code = 400, message = "Requisição sucedida"),
   			@ApiResponse(code = 404, message = "Recurso não encontrado"),
   			@ApiResponse(code = 500, message = "Sistema indisponivel")})
    public ResponseEntity<?> delete(@PathVariable Long id){
    	this.pedidoService.delete(id);
    	return ResponseEntity.badRequest().build();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}