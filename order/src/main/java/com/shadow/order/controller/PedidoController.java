package com.shadow.order.controller;

import com.shadow.order.client.OfferClient;
import com.shadow.order.client.ProductClient;
import com.shadow.order.domain.dto.dtorequest.PedidoDtoRequest;
import com.shadow.order.domain.dto.dtoresponse.PedidoDtoResponse;
import com.shadow.order.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/order")
@Api(tags = {"Order"}, value = "Order Controller")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private final PedidoService pedidoService;
    @Autowired
    private final OfferClient offerClient;
    @Autowired
    private final ProductClient productClient;

    @PostMapping("/")
    @ApiOperation(tags = {"Cadastro"}, value="Faça seu pedido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public ResponseEntity<PedidoDtoResponse> create(@RequestBody PedidoDtoRequest pedidoDtoRequest, @RequestParam @Valid Long id){
        PedidoDtoResponse pedidoDtoResponse = pedidoService.save(id, pedidoDtoRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(pedidoDtoResponse.getIdPedido()).toUri();
        return ResponseEntity.created(uri).body(pedidoDtoResponse);
    }
}