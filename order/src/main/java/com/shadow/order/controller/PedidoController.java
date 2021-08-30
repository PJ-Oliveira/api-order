package com.shadow.order.controller;

import com.shadow.order.service.ClientServiceProxy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/")
@Api(tags = {"Order"}, value = "Order Controller")
@CrossOrigin(origins = "*")
public class PedidoController {

    @Autowired
    private final ClientServiceProxy clientServiceProxy;

    @GetMapping
    @ApiOperation(httpMethod = "GET", notes = "Liste todas as ofertas disponíveis aqui no seu Order",tags = {"Lista completa"}, value="Lista de todas as ofertas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public List<Object> getOffer(){
        return clientServiceProxy.getOffer();
    }

    /*@GetMapping("{id}")
    @ApiOperation(httpMethod = "GET", notes = "Busque a oferta pelo seu respectivo ID",tags = {"Busque pelo ID"}, value="Encontre oferta por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição bem sucedida"),
            @ApiResponse(code = 401, message = "Não autorizado"),
            @ApiResponse(code = 404, message = "Recurso não encontrado"),
            @ApiResponse(code = 500, message = "Sistema Indisponível")
    })
    public List<Object> findOneOrder(Long id){
        return clientServiceProxy.getOfferById(id);
    }*/








}
