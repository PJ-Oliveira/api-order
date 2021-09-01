package com.shadow.order.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.PedidoService;
<<<<<<< HEAD
=======

>>>>>>> dev001
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
=======
>>>>>>> dev001

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
@Api(tags = {"Order"}, value = "Order Controller")
@CrossOrigin(origins = "*")
public class PedidoController {

   
  
    @Autowired
    private final PedidoService pedidoService;
<<<<<<< HEAD
    @Autowired
    private final OfferClient offerClient;
    @Autowired
    private final ProductClient productClient;
=======
>>>>>>> dev001

    @PostMapping("/addPedido")
    @ApiOperation(tags = {"Cadastro"}, value="Faça seu pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
<<<<<<< HEAD
    public ResponseEntity<PedidoDtoResponse> create(@RequestBody PedidoDtoRequest pedidoDtoRequest, @RequestParam @Valid Long id){
        PedidoDtoResponse pedidoDtoResponse = pedidoService.save(id, pedidoDtoRequest);
=======
    public ResponseEntity<PedidoDtoResponse> create(@RequestBody PedidoDtoRequest pedidoDtoRequest, @RequestParam  Long id, @RequestParam @Valid Long idProduto){
        PedidoDtoResponse pedidoDtoResponse = pedidoService.save(id, idProduto, pedidoDtoRequest);
>>>>>>> dev001
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(pedidoDtoResponse.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(pedidoDtoResponse);
    }
<<<<<<< HEAD
=======

>>>>>>> dev001
}